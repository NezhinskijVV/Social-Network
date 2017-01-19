package tag;

import model.Dancer;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.Collection;

/**
 * Created by Nezhinskij VV on 18.01.2017.
 *
 */
public class Friends extends TagSupport {
    private Collection<Dancer> friends;

    @Override
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().print(getFriendsList(friends));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }


    private static String getFriendsList(Collection<Dancer> friends)  {
        StringBuilder stringBuilder = new StringBuilder();
        for (Dancer friend: friends)
            stringBuilder.append("<tr><td><a href=\"/dancer/?id=")
                    .append(friend.getId())
                    .append("\">")
                    .append(friend.getFirstName())
                    .append("</a></td><td>")
                    .append(friend.getNickname())
                    .append("</a></td><td>")
                    .append(friend.getStyle())
                    .append("</a></td><td>")
                    .append(friend.getTelephone())
                    .append("</td></tr>");
        return stringBuilder.toString();
    }

    public void setFriends(Collection<Dancer> friends) {
        this.friends = friends;
    }
}
