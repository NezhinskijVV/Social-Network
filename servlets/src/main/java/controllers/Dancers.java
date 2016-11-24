package controllers;

import dao.DancerDao;
import dao.StyleDao;
import model.Dancer;
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
@WebServlet("/dancers")
public class Dancers extends HttpServlet {
    private DancerDao dancerDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        dancerDao = (DancerDao) config.getServletContext().getAttribute("dancerDao");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Collection<Dancer>  dancers = dancerDao.getAll();
        req.setAttribute("dancers", dancers);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/dancers/index.jsp");
        requestDispatcher.forward(req,resp);
    }


}
