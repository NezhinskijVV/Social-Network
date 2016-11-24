package tag;

import model.Style;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.Collection;

/**
 * Created by Nezhinskij VV on 24.11.2016.
 */
public class Styles extends TagSupport{
    private Collection<Style> styles;

    @Override
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().print(getUserList(styles));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }



    private static String getUserList(Collection<Style> styles) throws IOException {
        StringBuilder out = new StringBuilder();
        for (Style style: styles)
            out.append("<tr><td><a href=\"/style/?id=")
                    .append(style.getId())
                    .append("\">")
                    .append(style.getStyle())
                    .append("</a></td><td>")
                    .append(style.isClassic())
                    .append("</td></tr>");
        return out.toString();
    }


    public void setStyles(Collection<Style> styles) {
        this.styles = styles;
    }


}
