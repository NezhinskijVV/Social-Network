package dao.sql;

import common.ConnectionPool;
import common.ConnectionPoolException;
import dao.StyleDao;
import model.Style;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashSet;

/**
 *
 * Created by Nezhinskij VV on 23.11.2016.
 */
@SuppressWarnings({"SqlNoDataSourceInspection", "SqlDialectInspection"})
public class SqlStyleDao implements StyleDao {
    private ConnectionPool connectionPool;

    public SqlStyleDao(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public Collection<Style> getAll() {
        Collection<Style> stylesOfDance= new HashSet<>();
        try (
                Connection connection = connectionPool.getConnection();
                Statement st = connection.createStatement();
                ResultSet resultSet = st.executeQuery("SELECT id,style,classic"+
                        " FROM dancers_network.style")
        ) {
            while (resultSet.next()){
                boolean classical=(resultSet.getByte("classic") == 1);
                stylesOfDance.add(new Style(resultSet.getLong("id"), resultSet.getString("style"),classical));
            }
        } catch (SQLException | ConnectionPoolException e) {
            e.printStackTrace();
        }
        return stylesOfDance;
    }

    @Override
    public Style getById() {
        return null;
    }
}
