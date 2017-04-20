<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="prop" var="resourceBundle"/>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="../decoration/style.css" rel="stylesheet">
    <title>
       <fmt:message key="prop.messages" bundle="${resourceBundle}"/>
    </title>
</head>
<body>

<form method="POST" action="">
    <input type="text" name="message" autocomplete="off">
    <input class="b1" type="submit" value="Enter">
    <button class="b1"><a href="../friends"> <fmt:message key="prop.button.toFriends" bundle="${resourceBundle}"/></a></button>
    <button class="b1" type="submit" value="History" name="History"> <fmt:message key="prop.button.history" bundle="${resourceBundle}"/></button>
</form>

</body>
</html>