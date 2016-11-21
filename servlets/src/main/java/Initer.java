import common.ConnectionPool;
import common.ConnectionPoolException;
import dao.PersonDao;
import dao.UserDao;
import dao.sql.SqlPersonDao;
import dao.sql.SqlUserDao;
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

        PersonDao personDao = new SqlPersonDao(connectionPool);
        UserDao userDao = new SqlUserDao(connectionPool);

        context.setAttribute("personDao", personDao);
        context.setAttribute("userDao", userDao);
    }
}
