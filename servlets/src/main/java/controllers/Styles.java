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

/**
 * Created by Nezhinskij VV on 24.11.2016.
 * 
 */
@WebServlet("/styles")
public class Styles extends HttpServlet {
    private StyleDao styleDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        styleDao = (StyleDao) config.getServletContext().getAttribute("styleDao");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Collection<Style>  styles = styleDao.getAll();
        req.setAttribute("styles", styles);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/styles/index.jsp");
        requestDispatcher.forward(req,resp);
    }
}
