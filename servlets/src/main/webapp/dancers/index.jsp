<%@ page import="model.Style" %>
<%@ page import="java.util.HashSet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/dancers.tld" prefix="dancers"%>

<html>
<head>
    <title>Зарегистрированные танцоры</title>
</head>
<body>
<jsp:useBean id="dancers" class="java.util.HashSet" scope="request"/>
<table>
    <tr>
        <th>style</th>
        <th>isClassicalDance</th>
    </tr>
    <dancers:list dancers="${dancers}"/>
</table>
</body>
</html>