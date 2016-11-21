package logger;


import org.apache.log4j.Logger;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;


/**
 *
 * Created by Nezhinskij VV on 10.11.2016.
 */
@WebListener("/*")
public class ReqListener implements ServletRequestListener {

    private static final Logger LOG = Logger.getLogger(ReqListener.class);

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        LOG.info("request from " + request.getRequestURI() + " was created");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        LOG.info("request from " + request.getRequestURI() + " was destroyed");
    }
}
