package controllers;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * Created by Nezhinskij VV on 25.11.2016.
 */
@WebServlet("/dancer/")
public class WriteMessage extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/message/index.html");
        System.out.println("substring" + req.getQueryString().substring(3));
        req.getSession().setAttribute("to_id", req.getQueryString().substring(3));
        requestDispatcher.forward(req, resp);
    }
}
