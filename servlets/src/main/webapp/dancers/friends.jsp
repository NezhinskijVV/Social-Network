<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/friends.tld" prefix="friends" %>

<html>
<head>
    <title>Friends</title>
</head>
<body>
<%@ include file="menu.html" %>
<jsp:useBean id="friends" class="java.util.HashSet" scope="request"/>
<table>
    <tr>
        <th>friend</th>
        <th>style</th>
    </tr>
    <friends:list friends="${friends}"/>
</table>
</body>
</html>
