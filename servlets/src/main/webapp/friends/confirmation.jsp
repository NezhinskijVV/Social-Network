<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Detalya
  Date: 21.01.2017
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="prop" var="resourceBundle"/>
<html>
<head>
    <meta charset="UTF-8">
    <link href="../decoration/style.css" rel="stylesheet">
    <title>
        <fmt:message key="prop.friends.confirmation" bundle="${resourceBundle}"/></title>
    <meta http-equiv="Refresh" content="3; url= ../dancers">
</head>
<body>
    <fmt:message key="prop.friends.confirmation1" bundle="${resourceBundle}"/>
    ${sessionScope.name_of_friend}
    <fmt:message key="prop.friends.confirmation2" bundle="${resourceBundle}"/>
</body>
</html>
