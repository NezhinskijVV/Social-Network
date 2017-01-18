package dao.sql;

import common.ConnectionPool;
import common.ConnectionPoolException;
import dao.FriendsDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


public class SqlFriendsDao implements FriendsDao {
    private ConnectionPool connectionPool;

    public SqlFriendsDao(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public Collection<Long> getById(long id) throws ConnectionPoolException, SQLException {
        System.out.println("getById");
        Set<Long> friendsId = new HashSet<>();

        try (Connection connection = connectionPool.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT dancer_id1, dancer_id2 FROM dancers_network.friends " +
                             "WHERE (dancer_id1 = " + id + ") OR (dancer_id2= " + id + ");")
        ) {
            System.out.println("select friends");
            while (resultSet.next()) {
                //TODO: check this out
                long id1 = resultSet.getLong("dancer_id1");
                long id2 = resultSet.getLong("dancer_id2");

                if (id1 != id){
                    friendsId.add(id1);
                }else friendsId.add(id2);
            }

        } catch (SQLException | ConnectionPoolException e) {
            e.printStackTrace();
        }
        return friendsId;
    }
}

