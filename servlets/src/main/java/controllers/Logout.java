package controllers;

import dao.DancerDao;
import model.Dancer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Nezhinskij VV on 01.01.2017.
 */
@WebServlet("/logout")
public class Logout extends HttpServlet {
    private final static String KEY = "key";
    private final static String KEY2 = "key2";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute(KEY, null);
        session.setAttribute(KEY2, null);

        RequestDispatcher dispatcher = req.getRequestDispatcher("logout/index.html");
        dispatcher.forward(req, resp);
    }
}
