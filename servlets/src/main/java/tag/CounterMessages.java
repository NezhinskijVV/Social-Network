package tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Created by Nezhinskij VV on 24.11.2016.
 *
 */
public class CounterMessages extends TagSupport {
    private int count;

    @Override
    public int doStartTag() throws JspException {
        try {
            if (count != 0) {
                pageContext.getOut().print("(" + count+")");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }

    @SuppressWarnings("unused")
    public void setnotReadMessages(int count) {
        this.count = count;
    }

}
