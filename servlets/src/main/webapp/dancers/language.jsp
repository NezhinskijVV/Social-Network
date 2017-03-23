
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link href="../decoration/style.css" rel="stylesheet">
    <title> Language </title>
</head>
<body>
<%@ include file="menu.jsp" %>
<fmt:setLocale value="${Locale.getDefault()}"/>
<fmt:setBundle basename="prop" var="resourceBundle"/>

<fmt:message key="prop.cahngelanguage" bundle="${resourceBundle}"/>
</body>
</html>
