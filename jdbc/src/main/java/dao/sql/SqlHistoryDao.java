package dao.sql;

import common.ConnectionPool;
import common.ConnectionPoolException;
import dao.HistoryDao;
import model.MessageContainer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Nezhinskij VV on 29.03.2017.
 *
 */
public class SqlHistoryDao implements HistoryDao {
    private final ConnectionPool connectionPool;

    public SqlHistoryDao(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public Collection<MessageContainer> getByIds(long id1, long id2) {
        System.out.println("getByIds");
        List<MessageContainer> messages = new ArrayList<>();
        try (Connection connection = connectionPool.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT dancers_id1, dancers_id2, message, isSent FROM dancers_network.history" +
                             " WHERE ((history.dancers_id1 = " + id1 + " AND history.dancers_id2=" + id2 + ") " +
                             "OR (history.dancers_id1 = " + id2 + " AND history.dancers_id2=" + id1 + "));")
        ) {
            while (resultSet.next()) {
                MessageContainer ms = new MessageContainer(
                        resultSet.getLong("dancers_id1"),
                        resultSet.getLong("dancers_id2"),
                        resultSet.getString("message"),
                        resultSet.getBoolean("isSent")
                );
                messages.add(ms);
            }
        } catch (SQLException | ConnectionPoolException e) {
            e.printStackTrace();
        }
        return messages;
    }

    @Override
    public void addReadMessage(MessageContainer ms) {
        try (Connection connection = connectionPool.getConnection();
             Statement statement = connection.createStatement())
        {
            statement.executeUpdate(
                    "INSERT INTO dancers_network.history (dancers_id1,dancers_id2,message,isSent) VALUES(" + ms.getidDancer() + "," + ms.getidDancer2() + ",'" + ms.getMessage() + "', 0 );");

        } catch (SQLException | ConnectionPoolException e) {
            e.printStackTrace();
        }
    }
}

