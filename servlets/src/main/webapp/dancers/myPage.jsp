<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://myPage.com" prefix="page" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>

<head>
    <meta charset="UTF-8">
    <link href="../decoration/style.css" rel="stylesheet">
    <style>
        li {
            list-style-type: none; /* Убираем маркеры */
        }
    </style>
    <title>
        <fmt:setLocale value="${Locale.getDefault()}"/>
        <fmt:setBundle basename="prop" var="resourceBundle"/>
        <fmt:message key="prop.myPage" bundle="${resourceBundle}"/></title>
</head>
<body>
<%@ include file="menu.jsp" %>
<jsp:useBean id="dancer" class="java.lang.Object" scope="request"/>

<page:dancer dancer="${dancer}"/>



</body>
</html>
