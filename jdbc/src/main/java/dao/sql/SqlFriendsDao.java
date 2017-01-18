package dao.sql;

import common.ConnectionPool;
import common.ConnectionPoolException;
import dao.FriendsDao;
import model.Dancer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"SqlNoDataSourceInspection", "SqlDialectInspection"})
public class SqlFriendsDao implements FriendsDao {
    private ConnectionPool connectionPool;

    public SqlFriendsDao(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public Collection<Long> getIdsById(long id) throws ConnectionPoolException, SQLException {
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
                long id1 = resultSet.getLong("dancer_id1");
                long id2 = resultSet.getLong("dancer_id2");

                if (id1 != id) {
                    friendsId.add(id1);
                } else friendsId.add(id2);
            }

        } catch (SQLException | ConnectionPoolException e) {
            e.printStackTrace();
        }
        return friendsId;
    }

    @Override
    public Collection<Dancer> getDancersById(long id) throws ConnectionPoolException, SQLException {
        Set<Dancer> dancers = new HashSet<>();

        try (Connection connection = connectionPool.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT dancer.id, first_name,last_name,dob,nickname,email,password,telephone, style, dancer_id1,dancer_id2 " +
                             "FROM dancers_network.dancer " +
                             "LEFT JOIN dancers_network.style " +
                             "ON dancer.style_id= style.id "+
                             "LEFT JOIN dancers_network.friends ON dancer.id=dancer_id1  OR dancer.id=dancer_id2 " +
                             "WHERE dancer_id2=" + id + " OR dancer_id1 =" + id + " GROUP BY dancer.id;")
        ) {
            while (resultSet.next()) {
                Dancer dancer = new Dancer(
                        resultSet.getLong("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getDate("dob").toLocalDate(),
                        resultSet.getString("nickname"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("telephone"),
                        resultSet.getString("style")
                );
                dancers.add(dancer);
            }
        } catch (SQLException | ConnectionPoolException e) {
            e.printStackTrace();
        }
        return dancers;
    }
}

