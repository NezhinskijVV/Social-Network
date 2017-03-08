package controllers;

import dao.DancerDao;
import model.Dancer;
import model.History;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Created by Nezhinskij VV on 07.03.2017.
 *
 */
@WebServlet("/messages")
public class Messages extends HttpServlet {
    private History history;
    private DancerDao dancerDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        history = (History) config.getServletContext().getAttribute("history");
        dancerDao = (DancerDao) config.getServletContext().getAttribute("dancerDao");
    }


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Set<Dancer> fromNotReadMessages = new HashSet<>();
        Set<Long> set = history.fromNotReadMessages((Long) req.getSession().getAttribute("id"));
        for (Long l : set
                ) {
            fromNotReadMessages.add(dancerDao.getById(l));
        }
        req.setAttribute("fromMessages", fromNotReadMessages);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/dancers/messages.jsp");
        requestDispatcher.forward(req, resp);
    }
}
