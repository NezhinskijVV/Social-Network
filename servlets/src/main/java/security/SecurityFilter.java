package security;

import dao.DancerDao;
import httpFilter.HttpFilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebFilter("/foruser")
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

        HttpSession session = request.getSession(true);
        if ((session.getAttribute(KEY) != null) | (session.getAttribute(KEY2) != null)) {
            chain.doFilter(request, response);
        }
        Map<String, String[]> params = request.getParameterMap();
        if (params.containsKey("j_username") && params.containsKey("j_password")) {
            long id = authorize(params);
            if (id > 0){
                session.setAttribute(KEY, new Object());
                //   session.setAttribute("id", getId(params));
                session.setAttribute("id", id);
                chain.doFilter(request, response);
            } else request.getRequestDispatcher("user/loginError.jsp").forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("user/loginUser.html");
            dispatcher.forward(request, response);
        }
    }


    private long authorize(Map<String, String[]> parameterMap) {
        System.out.println("input: " + parameterMap.get("j_username")[0] + " " + parameterMap.get("j_password")[0]);
        return dancerDao.isRegistered(parameterMap.get("j_username")[0], parameterMap.get("j_password")[0]);
    }
}
