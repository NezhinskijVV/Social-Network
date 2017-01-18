package controllers;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

/**
 *
 * Created by Nezhinskij VV on 24.11.2016.
 */

//@WebServlet("/foruser")
public class UserContent extends HttpServlet {

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/privateUser.html");
        dispatcher.forward(request, response);

    }
}
