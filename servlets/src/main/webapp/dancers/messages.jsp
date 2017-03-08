<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/messages.tld" prefix="messages" %>

<html>
<head>
    <meta charset="UTF-8">
    <link href="../decoration/style.css" rel="stylesheet">
    <title> Friends </title>
</head>
<body>
<%@ include file="menu.jsp" %>
<jsp:useBean id="fromMessages" class="java.util.HashSet" scope="request"/>
These messages from these users:
<table>
    <messages:list fromMessages="${fromMessages}"/>
</table>
</body>
</html>