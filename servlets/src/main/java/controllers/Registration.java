package controllers;

import dao.DancerDao;
import encrypt.Encryptor;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.Map;

/**
 *
 * Created by Nezhinskij VV on 25.01.2017.
 */
@WebServlet("/register")
public class Registration extends HttpServlet {
    private DancerDao dancerDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        dancerDao = (DancerDao) config.getServletContext().getAttribute("dancerDao");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> params = req.getParameterMap();
        String email = params.get("email")[0].trim().toLowerCase();

        if (!dancerDao.existingEmail(email)) {
            System.out.println("email not existing");
            String password = params.get("password")[0];
            if (password.equals(params.get("confirmpassword")[0])) {
                try {
                    dancerDao.register(params.get("name")[0], params.get("surname")[0],
                            Date.valueOf(params.get("dob")[0]), params.get("nickname")[0],
                            email, Encryptor.encrypt(password), params.get("telephone")[0], Long.parseLong(params.get("option")[0]));
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
                req.getRequestDispatcher("user/confirmation.html").forward(req, resp);
            } else req.getRequestDispatcher("user/registrationError.html").forward(req, resp);
        } else req.getRequestDispatcher("user/registrationError.html").forward(req, resp);
    }
}
