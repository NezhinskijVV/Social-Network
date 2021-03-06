<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="prop" var="resourceBundle"/>
<html>
<head>
    <meta charset="UTF-8">
    <link href="../decoration/style.css" rel="stylesheet">
    <title>
        <fmt:message key="prop.language.tittle" bundle="${resourceBundle}"/>
    </title>
</head>
<body>
    <%@ include file="menu.jsp" %>
    <fmt:message key="prop.changelanguage" bundle="${resourceBundle}"/>
</body>
</html>
