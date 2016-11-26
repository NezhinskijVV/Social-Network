package dao.sql;

import common.ConnectionPool;
import common.ConnectionPoolException;
import dao.DancerDao;
import model.Dancer;

import javax.servlet.http.HttpServletRequest;
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
public class SqlDancerDao implements DancerDao {
    private ConnectionPool connectionPool;

    public SqlDancerDao(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public Collection<Dancer> getAll() {
        System.out.println("getALL");
        Collection<Dancer> dancers = new HashSet<>();
        try (Connection connection = connectionPool.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT dancer.id,first_name,last_name,dob,nickname," +
                             "email,password,telephone,style " +
                             "FROM dancers_network.dancer " +
                             "LEFT JOIN dancers_network.style " +
                             "ON dancer.id= style.id")
        ) {
            System.out.println("join");
            while (resultSet.next())
                dancers.add(
                        new Dancer(
                                resultSet.getLong("id"),
                                resultSet.getString("first_name"),
                                resultSet.getString("last_name"),
                                resultSet.getDate("dob").toLocalDate(),
                                resultSet.getString("nickname"),
                                resultSet.getString("email"),
                                resultSet.getString("password"),
                                resultSet.getString("telephone"),
                                resultSet.getString("style")
                        ));
        } catch (SQLException | ConnectionPoolException e) {
            e.printStackTrace();
        }
        return dancers;
    }

    @Override
    public Dancer getById(long id) {

//        Dancer dancer = null;
//        try (Connection connection = connectionPool.getConnection();
//             Statement statement = connection.createStatement();
//             ResultSet resultSet = statement.executeQuery(
//                     "SELECT  id,first_name,last_name,style,dob," +
//                             "email,password,address,telephone " +
//                             "FROM social_network.person WHERE socialNetwork.person.id =" + "'" + id + "'")
//        ) {
//            dancer = new Dancer(
//                    resultSet.getLong("id"),
//                    resultSet.getString("first_name"),
//                    resultSet.getString("last_name"),
//                    resultSet.getString("style"),
//                    resultSet.getDate("dob").toLocalDate(),
//                    resultSet.getString("email"),
//                    resultSet.getString("password"),
//                    resultSet.getString("address"),
//                    resultSet.getString("telephone")
//            );
//        } catch (SQLException| ConnectionPoolException e) {
//            e.printStackTrace();
//        }
//
//        return dancer;
        return null;
    }

    @Override
    public boolean isRegistered(HttpServletRequest req, String login, String hashPassword) {
        try (Connection connection = connectionPool.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT id,email,password FROM dancers_network.dancer WHERE email='"
                             + login + "' AND password='" + hashPassword + "'")
        ) {
            if( resultSet.next()){
                System.out.println(resultSet.getLong(1));
                req.getSession().setAttribute("id", resultSet.getLong(1));
                return true;
            }
        } catch (SQLException | ConnectionPoolException e) {
            e.printStackTrace();
        }
        return false;
    }
}