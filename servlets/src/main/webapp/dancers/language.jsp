<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <meta charset="UTF-8">
    <link href="../decoration/style.css" rel="stylesheet">
    <title>
        <fmt:setLocale value="${Locale.getDefault()}"/>
        <fmt:setBundle basename="prop" var="resourceBundle"/>
        <fmt:message key="prop.language.tittle" bundle="${resourceBundle}"/> </title>
</head>
<body>
<%@ include file="menu.jsp" %>

<fmt:message key="prop.cahngelanguage" bundle="${resourceBundle}"/>
</body>
</html>
