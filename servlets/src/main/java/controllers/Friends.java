package controllers;

import common.ConnectionPoolException;
import dao.DancerDao;
import dao.FriendsDao;
import model.Dancer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * Created by Nezhinskij VV on 18.01.2017.
 */
@WebServlet("/friends")
public class Friends extends HttpServlet {
    private DancerDao dancerDao;
    private FriendsDao friendsDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        dancerDao = (DancerDao) config.getServletContext().getAttribute("dancerDao");
        friendsDao = (FriendsDao) config.getServletContext().getAttribute("friendsDao");
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        long id = (long) req.getSession().getAttribute("id");
        System.out.println("out id" + id);

        Collection<Dancer> friends = null;
        try {
            friends = friendsDao.getDancersById(id);
            for (Dancer d : friends
                    ) {
                System.out.println(d.getFirstName());
            }

        } catch (ConnectionPoolException | SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("friends", friends);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/dancers/friends.jsp");
        requestDispatcher.forward(req,res);
    }
}
