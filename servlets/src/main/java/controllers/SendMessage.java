package controllers;

import dao.DancerDao;
import dao.sql.SqlDancerDao;
import model.Dancer;
import model.History;
import model.MessageContainer;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created
 * by Nezhinskij VV on 25.11.2016.
 */
@WebServlet("/send")
public class SendMessage extends HttpServlet {
    private History history;
    private DancerDao dancerDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        history = (History) config.getServletContext().getAttribute("history");
        dancerDao = (DancerDao) config.getServletContext().getAttribute("dancerDao");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // todo:  два листа прочитанных и нет и запись в базу
        // todo:  сделать через JSP

        long idDancer = (long) req.getSession().getAttribute("id");
        long idDancer2 = (long) req.getSession().getAttribute("to_id");
        String message = req.getParameter("message");

        Dancer dancer2 = dancerDao.getById(idDancer2);
        Dancer dancer = dancerDao.getById(idDancer);

        if (!message.equals("")) {
            MessageContainer messageContainer = new MessageContainer(idDancer, idDancer2, message, false);
            history.addToHistory(messageContainer);
        }

        PrintWriter out = resp.getWriter();
        ArrayList<MessageContainer> list = history.getList();
        for (MessageContainer m : list
                ) {
            if ((idDancer == m.getidDancer()) && (idDancer2 == m.getidDancer2())) {
                out.println("<br>" + dancer.getNickname() +  ": " + m.getMessage() + "</br>");
            } else if ((idDancer == m.getidDancer2()) && (idDancer2 == m.getidDancer())) {
                out.println("<br>" + dancer2.getNickname() + ": " + m.getMessage() + "</br>");
            }
        }
        req.getRequestDispatcher("message/index.jsp").include(req, resp);
    }
}
