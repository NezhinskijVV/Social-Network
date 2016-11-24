package tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.Collection;

/**
 *
 *
 * Created by Nezhinskij VV on 20.11.2016.
 */
public class Catalog extends TagSupport {
    private Collection<User> users;

    @Override
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().print(getUserList(users));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }



    private static String getUserList(Collection<User> users) throws IOException {
        StringBuilder out = new StringBuilder();
        for (User user: users)
            out.append("<tr><td><a href=\"/buy/?id=")
                    .append(user.getId())
                    .append("\">")
                    .append(user.getName())
                    .append("</a></td><td>")
                    .append(user.getStyle())
                    .append("</td></tr>");
        return out.toString();
    }


    public void setUsers(Collection<User> users) {
        this.users = users;
    }


}

