package controllers;

import dao.StyleDao;
import model.Style;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Locale;

/**
 * Created by Nezhinskij VV on 10.03.2017.
 *
 */
@WebServlet("/regpage")
public class BeforeRegistration extends HttpServlet {
    private StyleDao styleDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        styleDao = (StyleDao) config.getServletContext().getAttribute("styleDao");
    }

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Collection<Style> styles = styleDao.getAll();
        req.setAttribute("styles", styles);
        req.getSession().setAttribute("language", new Locale("en", "En"));
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/user/registration.jsp");
        requestDispatcher.forward(req, resp);
    }
}
