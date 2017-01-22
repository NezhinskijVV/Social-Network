package controllers;

import common.ConnectionPoolException;
import dao.DancerDao;
import dao.FriendsDao;
import model.Dancer;
import model.FriendsContainer;

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
 *
 * Created by Nezhinskij VV on 18.01.2017.
 */
@WebServlet("/friends")
public class Friends extends HttpServlet {
    private FriendsDao friendsDao;

    private static List<FriendsContainer> requestsOfFriends = new ArrayList<>();
    @Override
    public void init(ServletConfig config) throws ServletException {
        friendsDao = (FriendsDao) config.getServletContext().getAttribute("friendsDao");
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        long id = (long) req.getSession().getAttribute("id");
        System.out.println("out id" + id);
        Map<String, String[]> params = req.getParameterMap();
        String name = (String) req.getSession().getAttribute("nameOfFriend");

        if (params.containsKey("addFriend")) {
            System.out.println("addFriend");
            long toId = (long) req.getSession().getAttribute("to_id");
            requestsOfFriends.add(new FriendsContainer(id, toId,name ));
        }  if (params.containsKey("confirmAdding")){
            System.out.println("confirm adding");
            System.out.println("name " + name);
            req.getSession().setAttribute("nameOfAddingFriend", name);
            long toId = (long) req.getSession().getAttribute("to_id");
            requestsOfFriends.remove(new FriendsContainer(toId, id, name));
            friendsDao.addFriend(toId,id);
        }

        for (FriendsContainer fc:requestsOfFriends
             ) {
            if (fc.getIdTo() == id){
                req.getSession().setAttribute("to_id", fc.getIdFrom());
                requestsOfFriends.remove(fc);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/friends/addFriend.jsp");
                requestDispatcher.forward(req,res);
            }
        }
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
