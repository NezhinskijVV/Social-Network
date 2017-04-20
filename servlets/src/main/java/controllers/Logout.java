package controllers;

import dao.HistoryDao;
import model.History;
import model.MessageContainer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet("/logout")
public class Logout extends HttpServlet {
    private final static String KEY = "key";
    private final static String KEY2 = "key2";
    private History history;
    private HistoryDao historyDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        history = (History) config.getServletContext().getAttribute("history");
        historyDao = (HistoryDao) config.getServletContext().getAttribute("historyDao");

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();


        long idDancer = (long) req.getSession().getAttribute("id");
        System.out.println("idDancer" + idDancer);
        List<MessageContainer> list = history.getListOfReadMessagesById(idDancer);
        for (MessageContainer ms: list
             ) {
            historyDao.addReadMessage(ms);
        }
        session.setAttribute(KEY, null);
        session.setAttribute(KEY2, null);
        RequestDispatcher dispatcher = req.getRequestDispatcher("logout/index.jsp");
        dispatcher.forward(req, resp);
    }
}
