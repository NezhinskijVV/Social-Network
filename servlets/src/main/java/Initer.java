import common.ConnectionPool;
import common.ConnectionPoolException;
import dao.DancerDao;
import dao.FriendsDao;
import dao.StyleDao;
import dao.sql.SqlDancerDao;
import dao.sql.SqlFriendsDao;
import dao.sql.SqlStyleDao;

import model.History;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * Created by Nezhinskij VV on 17.11.2016.
 */

@WebListener
public class Initer implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        ConnectionPool connectionPool = new ConnectionPool();
        try {
            connectionPool.initPoolData();
        } catch (ConnectionPoolException e) {
            e.printStackTrace();
        }

        DancerDao dancerDao = new SqlDancerDao(connectionPool);
        StyleDao styleDao = new SqlStyleDao(connectionPool);
        History history = new History();
        FriendsDao friendsDao = new SqlFriendsDao(connectionPool);

        context.setAttribute("styleDao", styleDao);
        context.setAttribute("dancerDao", dancerDao);
        context.setAttribute("history", history);
        context.setAttribute("friendsDao", friendsDao);


    }
}
