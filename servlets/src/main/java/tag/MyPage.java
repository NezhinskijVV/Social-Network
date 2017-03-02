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
                .append("<li> <span class = \"information\"> First name: </span> ")
                .append(dancer.getFirstName())
                .append("</li>")
                .append("<li> <span class = \"information\"> Nickname: </span>")
                .append(dancer.getNickname())
                .append("</li>")
                .append("<li> <span class = \"information\"> Style: </span>")
                .append(dancer.getStyle())
                .append("</li>")
                .append("<li> <span class = \"information\"> Date of birth: </span>")
                .append(dancer.getDob())
                .append("</li>")
                .append("<li> <span class = \"information\"> Email: </span>")
                .append(dancer.getEmail())
                .append("</li>")
                .append("<li> <span class = \"information\"> Telephone: </span>")
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
