<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/dancers.tld" prefix="dancers" %>

<html>
<head>
    <title> Танцоры </title>
</head>
<body>
<jsp:useBean id="dancers" class="java.util.HashSet" scope="request"/>
<table>
    <tr>
        <th>dancer</th>
        <th>style</th>
    </tr>
    <dancers:list dancers="${dancers}"/>
</table>
</body>
</html>