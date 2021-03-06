package controllers;

import common.ConnectionPoolException;
import dao.DancerDao;
import dao.FriendsDao;
import logger.ReqListener;
import model.Dancer;
import model.FriendsContainer;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by Nezhinskij VV on 18.01.2017.
 */
@WebServlet("/friends/")
public class Friends extends HttpServlet {
    private FriendsDao friendsDao;
    private DancerDao dancerDao;
    private static final Logger LOG = Logger.getLogger(ReqListener.class);

    private static List<FriendsContainer> requestsOfFriends = new ArrayList<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        friendsDao = (FriendsDao) config.getServletContext().getAttribute("friendsDao");
        dancerDao = (DancerDao) config.getServletContext().getAttribute("dancerDao");
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        long id = (long) req.getSession().getAttribute("id");
        Map<String, String[]> params = req.getParameterMap();

        if (params.containsKey("addFriend")) {
            LOG.info("addFriend");
            long toId = (long) req.getSession().getAttribute("to_id");
            FriendsContainer fc = new FriendsContainer(id, toId);
            requestsOfFriends.add(fc);
        }
        if (params.containsKey("confirmAdding")) {
            LOG.info("confirm adding");
            long toId = (long) req.getSession().getAttribute("to_id");
            requestsOfFriends.remove(new FriendsContainer(toId, id));
            friendsDao.addFriend(toId, id);
        }

        LOG.info("check new friends");
        for (FriendsContainer fc :requestsOfFriends){
            System.out.println("from: "+fc.getIdFrom() + " to: " + fc.getIdTo() + " ");
        }

        for (FriendsContainer fc : requestsOfFriends
                ) {
            if (fc.getIdTo() == id) {
                req.getSession().setAttribute("to_id", fc.getIdFrom());
                req.getSession().setAttribute("nameOfAddingFriend", dancerDao.getById(fc.getIdFrom()).getNickname());
                requestsOfFriends.remove(fc);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/friends/addFriend.jsp");
                requestDispatcher.forward(req, res);
            }
        }
        Collection<Dancer> friends = null;
        try {
            friends = friendsDao.getDancersById(id);

        } catch (ConnectionPoolException | SQLException e) {
            e.printStackTrace();
        }
        for (Dancer d:friends){
            System.out.println(d.getFirstName());
        }
        req.setAttribute("friends", friends);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/dancers/friends.jsp");
        requestDispatcher.forward(req, res);
    }
}
