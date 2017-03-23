<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/friends.tld" prefix="friends" %>

<html>
<head>
    <meta charset="UTF-8">
    <link href="../decoration/style.css" rel="stylesheet">
    <title> Friends </title>
</head>
<body>
<%@ include file="menu.jsp" %>
<jsp:useBean id="friends" class="java.util.HashSet" scope="request"/>
<table>
    <tr>
        <th><fmt:message key="prop.friends.name" bundle="${resourceBundle}"/></th>
        <th><fmt:message key="prop.friends.nickname" bundle="${resourceBundle}"/></th>
        <th><fmt:message key="prop.friends.style" bundle="${resourceBundle}"/></th>
        <th><fmt:message key="prop.friends.telephone" bundle="${resourceBundle}"/></th>
    </tr>
    <friends:list friends="${friends}"/>
</table>
</body>
</html>