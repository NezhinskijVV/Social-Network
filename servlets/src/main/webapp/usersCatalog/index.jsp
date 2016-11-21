<%@ page import="model.User" %>
<%@ page import="java.util.HashSet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/socialNetwork.tld" prefix="network"%>

<html>
<head>
    <title>Каталог</title>
</head>
<body>
<jsp:useBean id="users" class="java.util.HashSet" scope="request"/>
<table>
    <tr>
        <th>name</th>
        <th>style</th>
    </tr>
    <network:list users="${users}"/>
</table>
</body>
</html>
