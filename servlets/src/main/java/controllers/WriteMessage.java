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
 *
 *
 * Created by Nezhinskij VV on 25.11.2016.
 */
@WebServlet("/dancer/")
public class WriteMessage extends HttpServlet {
    private History history;
    private DancerDao dancerDao;
    private HistoryDao historyDao;
    private final static int messagesOnPage = 10;

    @Override
    public void init(ServletConfig config) throws ServletException {
        history = (History) config.getServletContext().getAttribute("history");
        historyDao = (HistoryDao) config.getServletContext().getAttribute("historyDao");
        dancerDao = (DancerDao) config.getServletContext().getAttribute("dancerDao");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        long idDancer = (long) req.getSession().getAttribute("id");
        long idDancer2 = Long.parseLong(req.getParameter("id"));
        String message = req.getParameter("message");
        PrintWriter out = resp.getWriter();

        if (req.getParameter("Enter") != null) {
            if ((message != null) && !message.equals("")) {
                MessageContainer messageContainer = new MessageContainer(idDancer, idDancer2, message, false);
                history.addToHistory(messageContainer);
                String url = "/dancer" + "/?id=" + idDancer2;
                resp.sendRedirect(url);
            }
        } else if (req.getParameter("History") != null) {
            System.out.println("HISTORY NOT NULL");
            printList((List<MessageContainer>) historyDao.getByIds(idDancer, idDancer2), idDancer, idDancer2, out);
        }

        ArrayList<MessageContainer> list = history.getList();
        list = (ArrayList<MessageContainer>) getListOfTwoUsers(list, idDancer, idDancer2);
        int quantityOfPages;
        if (req.getParameter("History") != null) {
            quantityOfPages = 1;
            printList(list, idDancer, idDancer2, out);
            req.setAttribute("quantityOfPages", quantityOfPages);
        } else {
            quantityOfPages = (int) Math.floor(list.size() / messagesOnPage) + 1;
            req.setAttribute("quantityOfPages", quantityOfPages);
            if (req.getParameter("page") == null) {
                printListOfTwoUsers(list, idDancer, idDancer2, out, quantityOfPages);
            } else {
                printListOfTwoUsers(list, idDancer, idDancer2, out, Integer.parseInt(req.getParameter("page")));
            }
        }
        req.getRequestDispatcher("/message/index.jsp").include(req, resp);
    }

    private List<MessageContainer> getListOfTwoUsers(List<MessageContainer> list, long idDancer, long idDancer2) {
        List<MessageContainer> listOfTwoUsers = new ArrayList<>();
        for (MessageContainer m : list
                ) {
            if (((idDancer == m.getidDancer()) && (idDancer2 == m.getidDancer2())) | ((idDancer == m.getidDancer2()) && (idDancer2 == m.getidDancer()))) {
                listOfTwoUsers.add(m);
            }
        }
        return listOfTwoUsers;
    }

    private void printList(List<MessageContainer> list, long idDancer, long idDancer2, PrintWriter out) {
        for (MessageContainer m : list
                ) {
            printMessage(m, idDancer, idDancer2, out);
        }
    }

    private void printListOfTwoUsers(List<MessageContainer> list, long idDancer, long idDancer2, PrintWriter out, int numberOfPage) {
        if (!list.isEmpty()) {
            int to;
            if (numberOfPage * messagesOnPage >= list.size()) {
                to = list.size() - 1;
            } else {
                to = numberOfPage * messagesOnPage - 1;
            }
            for (int i = messagesOnPage * (numberOfPage - 1); i <= to; i++) {
                MessageContainer m = list.get(i);
                printMessage(m, idDancer, idDancer2, out);
            }
        }
    }

    private void printMessage(MessageContainer m, long idDancer, long idDancer2, PrintWriter out) {
        Dancer dancer2 = dancerDao.getById(idDancer2);
        Dancer dancer = dancerDao.getById(idDancer);
        if ((idDancer == m.getidDancer()) && (idDancer2 == m.getidDancer2())) {
            out.println("<br>" + dancer.getNickname() + ": " + m.getMessage() + "</br>");
        } else if ((idDancer == m.getidDancer2()) && (idDancer2 == m.getidDancer())) {
            out.println("<br>" + dancer2.getNickname() + ": " + m.getMessage() + "</br>");
            m.setRead();
        }
    }
}
