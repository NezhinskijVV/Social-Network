package controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

/**
 * Created by Nezhinskij VV on 15.03.2017.
 *
 */
@WebServlet("/change")
public class ChangeLanguage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getSession().getAttribute("language").equals(new Locale("ru", "Ru"))) {
            req.getSession().setAttribute("language", new Locale("en", "En"));
            Locale.setDefault(new Locale("en", "En"));
        } else {
            Locale.setDefault(new Locale("ru", "Ru"));
            req.getSession().setAttribute("language", new Locale("ru", "Ru"));
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("dancers/language.jsp");
        requestDispatcher.forward(req, resp);
    }
}
