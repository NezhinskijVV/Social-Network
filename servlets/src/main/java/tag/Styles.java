package tag;

import model.Style;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.Collection;

/**
 *
 *
 * Created by Nezhinskij VV on 24.11.2016.
 */
public class Styles extends TagSupport{
    private Collection<Style> styles;

    @Override
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().print(getStylesList(styles));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }



    private static String getStylesList(Collection<Style> styles) throws IOException {
        StringBuilder out = new StringBuilder();
        for (Style s: styles)
            out.append("<input type=\"radio\" name=\"option\" required = \"true\" value=\"").append(s.getId()).append("\" >").append(s.getStyle()).append("<br>");
        return out.toString();
    }

    @SuppressWarnings("unused")
    public void setStyles(Collection<Style> styles) {
        this.styles = styles;
    }

}
