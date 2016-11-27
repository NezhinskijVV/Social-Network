package controllers;

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
 *by Nezhinskij VV on 25.11.2016.
 */
@WebServlet("/send")
public class SendMessage extends HttpServlet {

    private History history;

    @Override
    public void init(ServletConfig config) throws ServletException {
        history = (History) config.getServletContext().getAttribute("history");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // todo:  два листа прочитанных и нет и запись в базу

        long idDancer = (long) req.getSession().getAttribute("id");
        long idDancer2 = Long.parseLong((String) req.getSession().getAttribute("to_id"));
        String message = req.getParameter("message");

//        System.out.println("I" + idDancer);
//        System.out.println("you" + idDancer2);
//        System.out.println("message" + message);
        MessageContainer messageContainer = new MessageContainer(idDancer, idDancer2, message, false);
        history.addToHistory(messageContainer);

        PrintWriter out = resp.getWriter();
        ArrayList<MessageContainer> list = history.getList();
        for (MessageContainer m : list
                ) {
//            System.out.println(" id FROM " + idDancer + " id TO " + idDancer2 +
//                    "mess id FROM " + m.getidDancer() + "mess id TO" + m.getidDancer2() + " " + m.getMessage());

            if (((idDancer == m.getidDancer()) && (idDancer2 == m.getidDancer2())) |
                    ((idDancer == m.getidDancer2()) && (idDancer2 == m.getidDancer()))) {
                out.println("<br>" + m.getidDancer() + " " + m.getidDancer2() + " " + m.getMessage() + "</br>");
            }
        }
        req.getRequestDispatcher("message/index.jsp").include(req, resp);
    }
}
