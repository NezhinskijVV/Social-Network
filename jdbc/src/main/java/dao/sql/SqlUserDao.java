package dao.sql;

import common.ConnectionPool;
import common.ConnectionPoolException;
import dao.UserDao;
import model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashSet;

/**

 * Created by Nezhinskij VV on 17.11.2016.
 */
@SuppressWarnings("ALL")
public class SqlUserDao implements UserDao {
    private ConnectionPool connectionPool;

    public SqlUserDao(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public Collection<User> getAll() {

        Collection<User> users = new HashSet<>();

        try (Connection connection = connectionPool.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT id,first_name,style FROM social_network.person")

        ) {
            System.out.println("eeeeeee");
            while (resultSet.next())
                users.add(
                        new User(
                                resultSet.getLong("id"),
                                resultSet.getString("first_name"),
                                resultSet.getString("style")
                        ));
        } catch (SQLException | ConnectionPoolException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User getById(long id) {
       
       //// TODO: 22.11.2016 create 
        return null;
    }

//    @Override
//    public User getById(long id) {
//        User user = null;
//        try (Connection connection = connectionPool.getConnection();
//             Statement statement = connection.createStatement();
//             ResultSet resultSet = statement.executeQuery(
//                     "SELECT id,name,caliber FROM gunshop.guns WHERE gunshop.guns.id"  + "=" + "'" +  id + "'")
//        ) {
//            user = new User(
//                    resultSet.getLong("id"),
//                    resultSet.getString("name")
//            );
//        } catch (SQLException| ConnectionPoolException e) {
//            e.printStackTrace();
//        }
//        return user;
//    }
}
