package controllers;

import dao.FriendsDao;

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
@WebServlet("/friend/")
public class ForAllUsers extends HttpServlet {
    private FriendsDao friendsDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        friendsDao = (FriendsDao) config.getServletContext().getAttribute("friendsDao");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("FOR ALL USERS");
        System.out.println( req.getSession().getAttribute("id"));
        System.out.println(req.getQueryString().substring(3));


        long id = (long) req.getSession().getAttribute("id");
        long friendsId = Long.parseLong(req.getQueryString().substring(3));
        req.getSession().setAttribute("to_id", friendsId);
        if (friendsDao.isFriend(id, friendsId)) {
            System.out.println("is a friend");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/message/index.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            System.out.println("isn't  a friend");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/message/index.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}