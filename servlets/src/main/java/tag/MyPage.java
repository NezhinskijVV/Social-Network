package tag;

import model.Dancer;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 *
 * Created by Nezhinskij VV on 02.12.2016.
 */
public class MyPage extends TagSupport {
    private Dancer dancer;
    @Override
    public int doStartTag() throws JspException {
        StringBuilder out = new StringBuilder();
        out.append("<ul>")
                .append("<li> First name: ")
                .append(dancer.getFirstName())
                .append("</li>")
                .append("<li> Nickname: ")
                .append(dancer.getNickname())
                .append("</li>")
                .append("<li> Style:")
                .append(dancer.getStyle())
                .append("</li>")
                .append("<li> Date of birth:")
                .append(dancer.getDob())
                .append("</li>")
                .append("<li> Email:")
                .append(dancer.getEmail())
                .append("</li>")
                .append("<li> Telephone:")
                .append(dancer.getTelephone())
                .append("</li>")
                .append("</ul>");
        try {
            pageContext.getOut().print(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }

    public void setDancer(Dancer dancer) {
        this.dancer = dancer;
    }
}
