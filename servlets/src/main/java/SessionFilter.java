import model.History;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Nezhinskij VV on 09.03.2017.
 *
 */
public class SessionFilter implements Filter {
    private History history;

    @Override
    public void init(FilterConfig config) throws ServletException {
        history = (History) config.getServletContext().getAttribute("history");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("COUNTER FILTER");
        long id = (long) ((HttpServletRequest) req).getSession().getAttribute("id");

        int countOfNotRead = history.notReadMessages(id);
        int wasCountOfNotRead = 0;
        if (req.getAttribute("notReadMessages") != null) {
            wasCountOfNotRead = (int) req.getAttribute("notReadMessages");
        }
        if ((countOfNotRead != 0) && (wasCountOfNotRead < countOfNotRead)) {
            req.setAttribute("notReadMessages", countOfNotRead);
        }

        chain.doFilter(req, response);
    }
}
