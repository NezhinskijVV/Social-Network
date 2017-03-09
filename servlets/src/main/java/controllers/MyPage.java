package controllers;

import dao.DancerDao;
import model.Dancer;
import model.History;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Nezhinskij VV on 02.12.2016.
 *
 */
@WebServlet({"/myPage", "/foruser"})
public class MyPage extends HttpServlet {
    private History history;
    private DancerDao dancerDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        history = (History) config.getServletContext().getAttribute("history");
        dancerDao = (DancerDao) config.getServletContext().getAttribute("dancerDao");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = (long) req.getSession().getAttribute("id");
        Dancer dancer = dancerDao.getById(id);
        req.setAttribute("dancer", dancer);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/dancers/myPage.jsp");
        requestDispatcher.forward(req, resp);
    }
}
