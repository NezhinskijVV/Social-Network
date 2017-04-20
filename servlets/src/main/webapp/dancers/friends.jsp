<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/friends.tld" prefix="friends" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="prop" var="resourceBundle"/>
<html>
<head>
    <meta charset="UTF-8">
    <link href="../decoration/style.css" rel="stylesheet">
    <title>
        <fmt:message key="prop.friends" bundle="${resourceBundle}"/>
    </title>
</head>
<body>
<%@ include file="menu.jsp" %>
<jsp:useBean id="friends" class="java.util.HashSet" scope="request"/>
<c:if test="${!empty friends}">
<table>
    <tr>
        <th><fmt:message key="prop.friends.name" bundle="${resourceBundle}"/></th>
        <th><fmt:message key="prop.friends.nickname" bundle="${resourceBundle}"/></th>
        <th><fmt:message key="prop.friends.style" bundle="${resourceBundle}"/></th>
        <th><fmt:message key="prop.friends.telephone" bundle="${resourceBundle}"/></th>
    </tr>
    <friends:list friends="${friends}"/>
</table>
</c:if>
<c:if test="${empty friends}">
    <fmt:message key="prop.friends.noFriends" bundle="${resourceBundle}"/>
</c:if>

</body>
</html>