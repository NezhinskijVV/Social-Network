package dao.sql;

import common.ConnectionPool;
import common.ConnectionPoolException;
import dao.PersonDao;
import model.Person;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashSet;

/**
 *
 * Created by Nezhinskij VV on 17.11.2016.
 */
@SuppressWarnings("ALL")
public class SqlPersonDao implements PersonDao {
    private ConnectionPool connectionPool;

    public SqlPersonDao(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public Collection<Person> getAll() {

        Collection<Person> persons = new HashSet<>();
        try (Connection connection = connectionPool.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT id,first_name,last_name,style,dob," +
                             "email,password,address,telephone " +
                             "FROM social_network.person")
        ) {
            while (resultSet.next())
                persons.add(
                        new Person(
                                resultSet.getLong("id"),
                                resultSet.getString("first_name"),
                                resultSet.getString("last_name"),
                                resultSet.getString("style"),
                                resultSet.getDate("dob").toLocalDate(),
                                resultSet.getString("email"),
                                resultSet.getString("password"),
                                resultSet.getString("address"),
                                resultSet.getString("telephone")
                        ));
        } catch (SQLException| ConnectionPoolException e) {
            e.printStackTrace();
        }
        return persons;
    }

    @Override
    public Person getById(long id) {

        Person person = null;
        try (Connection connection = connectionPool.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT  id,first_name,last_name,style,dob," +
                             "email,password,address,telephone " +
                             "FROM social_network.person WHERE socialNetwork.person.id =" + "'" + id + "'")
        ) {
            person = new Person(
                    resultSet.getLong("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("style"),
                    resultSet.getDate("dob").toLocalDate(),
                    resultSet.getString("email"),
                    resultSet.getString("password"),
                    resultSet.getString("address"),
                    resultSet.getString("telephone")
            );
        } catch (SQLException| ConnectionPoolException e) {
            e.printStackTrace();
        }

        return person;
    }

    @Override
    public boolean isRegistered(String login, String hashPassword) {
        try (Connection connection = connectionPool.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT  email,password " +
                             "FROM social_network.person WHERE social_network.person.email =" + "'" + login + "'" +
                             " AND  social_network.person.password =" + "'" + hashPassword + "'")
        ) {
            return resultSet.next();
        } catch (SQLException| ConnectionPoolException e) {
            e.printStackTrace();
        }

        return false;
    }
}