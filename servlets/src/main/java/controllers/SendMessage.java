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
 * Created by Nezhinskij VV on 25.11.2016.
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

        long id_dancer = (long) req.getSession().getAttribute("id");
        long id_dancer2 = Long.parseLong((String) req.getSession().getAttribute("to_id"));
        String message = req.getParameter("message");

        System.out.println("I" + id_dancer);
        System.out.println("you" + id_dancer2);
        System.out.println("message" + message);
        //MessageContainer messageContainer = new MessageContainer(id_dancer, id_dancer2, message, false);
        PrintWriter out = resp.getWriter();
        ArrayList<MessageContainer> list = history.getList();
        for (MessageContainer m : list
                ) {
            if (((long) req.getSession().getAttribute("id") == m.getId_dancer())
                    | ((long) req.getSession().getAttribute("id") == m.getId_dancer2())) {
                out.println(m.getId_dancer() + " " + m.getMessage() + "</br>");
            }
        }
        req.getRequestDispatcher("message/index.html").include(req, resp);
    }
}
