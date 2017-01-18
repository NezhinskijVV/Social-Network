package tag;

import model.Dancer;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.Collection;

/**
 *
 * Created by Nezhinskij VV on 24.11.2016.
 */
public class Dancers extends TagSupport{
    private Collection<Dancer> dancers;

    @Override
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().print(getDancerList(dancers));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }


    private static String getDancerList(Collection<Dancer> dancers) throws IOException {
        StringBuilder out = new StringBuilder();
        for (Dancer dancer: dancers)
            out.append("<tr><td><a href=\"/dancer/?id=")
                    .append(dancer.getId())
                    .append("\">")
                    .append(dancer.getNickname())
                    .append("</a></td><td>")
                    .append(dancer.getStyle())
                    .append("</td></tr>");
        return out.toString();
    }

    public void setDancers(Collection<Dancer> dancers) {
        this.dancers = dancers;
    }
}
