<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://myPage.com" prefix="page" %>
<html>
<head>
    <title>My page</title>
</head>
<body bgcolor="#ADD8E6">
<%@ include file="menu.html" %>

<jsp:useBean id="dancer" class="java.lang.Object" scope="request"/>

<page:dancer dancer="${dancer}"/>

<%--First Name: --%>
<%--Last Name: <page:dancer dancer="${dancer.lastName}"/>--%>
<%--Nickname: <page:dancer dancer="${dancer.nickname}"/>--%>
<%--Style: <page:dancer dancer="${dancer.style}"/>--%>
<%--Email: <page:dancer dancer="${dancer.email}"/>--%>
<%--Telephone: <page:dancer dancer="${dancer.telephone}"/>--%>

</body>
</html>
