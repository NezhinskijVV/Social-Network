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
        System.out.println("session" + req.getSession().getId());
        System.out.println("QUERYSTRING " + req.getQueryString());
        System.out.println("substring " + req.getQueryString().substring(3));
        req.getSession().setAttribute("to_id", Long.parseLong(req.getQueryString().substring(3)));
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/message/index.jsp");
        requestDispatcher.forward(req, resp);
    }
}
