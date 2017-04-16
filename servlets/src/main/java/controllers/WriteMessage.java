package controllers;


import dao.DancerDao;
import dao.HistoryDao;
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
import java.util.List;

/**
 * Created by Nezhinskij VV on 25.11.2016.
 */
@WebServlet("/dancer/")
public class WriteMessage extends HttpServlet {
    private History history;
    private DancerDao dancerDao;
    private HistoryDao historyDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        history = (History) config.getServletContext().getAttribute("history");
        historyDao = (HistoryDao) config.getServletContext().getAttribute("historyDao");
        dancerDao = (DancerDao) config.getServletContext().getAttribute("dancerDao");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        long idDancer = (long) req.getSession().getAttribute("id");
        long idDancer2 = Long.parseLong(req.getQueryString().substring(3));
        String message = req.getParameter("message");
        PrintWriter out = resp.getWriter();
        System.out.println("idDancer + " + idDancer);
        System.out.println("idDancer2 + " + idDancer2);

        if (req.getParameter("History")!= null) {
            System.out.println("HISTORY NOT NULL");
            printList((List) historyDao.getByIds(idDancer, idDancer2), idDancer, idDancer2, out);
        }

        if ((message != null) && !message.equals("")) {
            MessageContainer messageContainer = new MessageContainer(idDancer, idDancer2, message, false);
            history.addToHistory(messageContainer);
        }

        ArrayList<MessageContainer> list = history.getList();
        printList(list, idDancer, idDancer2, out);
        req.getRequestDispatcher("/message/index.jsp").include(req, resp);
    }

    private void printList(List<MessageContainer> list, long idDancer, long idDancer2, PrintWriter out) {
        Dancer dancer2 = dancerDao.getById(idDancer2);
        Dancer dancer = dancerDao.getById(idDancer);
        for (MessageContainer m : list
                ) {
            if ((idDancer == m.getidDancer()) && (idDancer2 == m.getidDancer2())) {
                out.println("<br>" + dancer.getNickname() + ": " + m.getMessage() + "</br>");
            } else if ((idDancer == m.getidDancer2()) && (idDancer2 == m.getidDancer())) {
                out.println("<br>" + dancer2.getNickname() + ": " + m.getMessage() + "</br>");
                m.setRead();
            }
        }
    }
}
