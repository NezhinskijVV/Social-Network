package dao.sql;

import common.ConnectionPool;
import common.ConnectionPoolException;
import dao.DancerDao;
import model.Dancer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

/**
 * Created by Nezhinskij VV on 17.11.2016.
 *
 */

@SuppressWarnings({"SqlNoDataSourceInspection", "SqlDialectInspection"})
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
                             "ON dancer.style_id= style.id")
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

        System.out.println("getById");
        Dancer dancer = null;

        try (Connection connection = connectionPool.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT dancer.id,first_name,last_name,dob,nickname," +
                             "email,password,telephone,style " +
                             "FROM dancers_network.dancer " +
                             "LEFT JOIN dancers_network.style " +
                             "ON dancer.style_id= style.id " +
                             "WHERE dancer.id =  " + id)
        ) {
            System.out.println("join");
            while (resultSet.next())
                dancer = new Dancer(
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
        } catch (SQLException | ConnectionPoolException e) {
            e.printStackTrace();
        }
        return dancer;
    }

    @Override
    public boolean existingEmail(String email) {
        System.out.println("existing email?");

        try (Connection connection = connectionPool.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT email FROM dancers_network.dancer WHERE email =  '" + email + "'; ")) {
            return resultSet.first();

        } catch (SQLException | ConnectionPoolException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public long isRegistered(String login, String hashPassword) {
        try (Connection connection = connectionPool.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT id,email,password FROM dancers_network.dancer WHERE email='"
                             + login + "' AND password='" + hashPassword + "'")
        ) {
            if (resultSet.next()) {
                //req.getSession().setAttribute("id", resultSet.getLong(1));
                return resultSet.getLong(1);
            }
        } catch (SQLException | ConnectionPoolException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void register(String name, String surname, Date dob, String nickname, String email,
                         String password, String telephone, long style) {

        try (Connection connection = connectionPool.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(
                    "INSERT INTO dancers_network.dancer (first_name,last_name, dob, nickname, " +
                            "email,password, telephone, style_id) \n" +
                            "VALUES( '" + name + "' , '" + surname + "' , '" + dob + "' , '" + nickname + "' , '"
                            + email + "' , '" + password + "' , '" + telephone + "' , " + style + ");");

        } catch (SQLException | ConnectionPoolException e) {
            e.printStackTrace();
        }
    }
}