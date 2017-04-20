package security;

import dao.DancerDao;
import encrypt.Encryptor;
import httpFilter.HttpFilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.Map;

public class SecurityFilter implements HttpFilter {
    private final static String KEY = "key";
    private final static String KEY2 = "key2";
    private DancerDao dancerDao;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        dancerDao = (DancerDao) filterConfig.getServletContext().getAttribute("dancerDao");
    }

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("SECURITY FILTER");
        HttpSession session = request.getSession(true);
        String url =request.getRequestURL().toString();
        if (url.contains("/regist") ||
                request.getRequestURL().toString().contains("/regpage")) {
            System.out.println("registration");
            chain.doFilter(request, response);
        }
        if (url.contains("/decoration/images/bye.jpg")) {
            chain.doFilter(request, response);
        }
        else {
            Map<String, String[]> params = request.getParameterMap();
            if ((session.getAttribute(KEY) != null) | (session.getAttribute(KEY2) != null)) {
                System.out.println("IT's okay");
                chain.doFilter(request, response);
            } else if (params.containsKey("j_username") && params.containsKey("j_password")) {
                long id = 0;
                try {
                    id = authorize(params);
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
                if (id > 0) {
                    session.setAttribute(KEY, new Object());
                    System.out.println("WRITE THIS KEY" + session.getAttribute(KEY));
                    System.out.println("SET ID");
                    session.setAttribute("id", id);
                    chain.doFilter(request, response);
                } else request.getRequestDispatcher("user/loginError.jsp").forward(request, response);
            } else {
                request.getSession().setAttribute("language", new Locale("en", "En"));
                System.out.println("attribute KEY from current session: " + session.getAttribute(KEY));
                System.out.println("attribute KEY2 from current session: " + session.getAttribute(KEY2));
                RequestDispatcher dispatcher = request.getRequestDispatcher("user/loginUser.html");
                dispatcher.forward(request, response);
            }
        }
    }

    private long authorize(Map<String, String[]> parameterMap) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        System.out.println("input: " + parameterMap.get("j_username")[0] + " " + parameterMap.get("j_password")[0]);
        return dancerDao.isRegistered(parameterMap.get("j_username")[0], Encryptor.encrypt(parameterMap.get("j_password")[0]));
    }
}
