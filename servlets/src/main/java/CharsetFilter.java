import org.apache.log4j.Logger;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Nezhinskij VV on 09.11.2016.
 *
 */
public class CharsetFilter implements Filter {
    private String encoding;
    private static final Logger LOG = Logger.getLogger(CharsetFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encoding = filterConfig.getInitParameter("characterEncoding");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("CHARSET FILTER");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        LOG.info("Charset was set.");
        chain.doFilter(request,response);
    }
}