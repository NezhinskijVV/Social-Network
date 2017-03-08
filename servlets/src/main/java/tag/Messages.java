package tag;

import model.Dancer;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.Collection;

/**
 *
 * Created by Nezhinskij VV on 07.03.2017.
 */
public class Messages extends TagSupport {
    private Collection<Dancer> fromMessages;

    @Override
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().print(getFromList(fromMessages));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }


    private static String getFromList(Collection<Dancer> friends)  {
        StringBuilder stringBuilder = new StringBuilder();
        for (Dancer friend: friends)
            stringBuilder.append("<tr><td><a href=\"/dancer/?id=")
                    .append(friend.getId())
                    .append("\">")
                    .append(friend.getFirstName())
                    .append("</a></td><td>")
                    .append(friend.getNickname())
                    .append("</td><td>")
                    .append(friend.getStyle())
                    .append("</td></tr>");
        return stringBuilder.toString();
    }

    public void setFromMessages(Collection<Dancer> fromMessages) {
        this.fromMessages = fromMessages;
    }
}

