<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/messages.tld" prefix="messages" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<html>
<head>
    <meta charset="UTF-8">
    <link href="../decoration/style.css" rel="stylesheet">
    <title>
        <fmt:setLocale value="${Locale.getDefault()}"/>
        <fmt:setBundle basename="prop" var="resourceBundle"/>
        <fmt:message key="prop.messages" bundle="${resourceBundle}"/>
    </title>
</head>
<body>
<%@ include file="menu.jsp" %>
<jsp:useBean id="fromMessages" class="java.util.HashSet" scope="request"/>


<c:if test="${empty fromMessages}"><fmt:message key="prop.messages.noMessages" bundle="${resourceBundle}"/></c:if>


<c:if test="${!empty fromMessages}">
    <fmt:message key="prop.messages.from" bundle="${resourceBundle}"/></c:if>
<table>
    <messages:list fromMessages="${fromMessages}"/>
</table>

</body>
</html>