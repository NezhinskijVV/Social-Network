package controllers;

import dao.DancerDao;
import dao.FriendsDao;
import logger.ReqListener;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * Created by Nezhinskij VV on 19.01.2017.
 */
@WebServlet("/dancer/")
public class ForAllUsers extends HttpServlet {
    private FriendsDao friendsDao;
    private DancerDao dancerDao;
    private static final Logger LOG = Logger.getLogger(ReqListener.class);

    @Override
    public void init(ServletConfig config) throws ServletException {
        friendsDao = (FriendsDao) config.getServletContext().getAttribute("friendsDao");
        dancerDao = (DancerDao) config.getServletContext().getAttribute("dancerDao");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("FOR ALL USERS");
        LOG.info( req.getSession().getAttribute("id"));


        long id = (long) req.getSession().getAttribute("id");
        long friendsId = Long.parseLong(req.getQueryString().substring(3).split("&")[0]);
        req.getSession().setAttribute("to_id", friendsId);
        req.getSession().setAttribute("nameOfFriend", dancerDao.getById(friendsId).getNickname());
        if (friendsDao.isFriend(id, friendsId)) {
            LOG.info("is a friend");
            resp.sendRedirect("/friend/?id="+friendsId +"&page=1");
        } else {
            LOG.info("isn't  a friend");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/friends/index.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}