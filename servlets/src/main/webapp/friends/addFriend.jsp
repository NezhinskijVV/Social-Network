<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Detalya
  Date: 21.01.2017
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link href="../decoration/style.css" rel="stylesheet">
    <title><fmt:setLocale value="${Locale.getDefault()}"/>
        <fmt:setBundle basename="prop" var="resourceBundle"/>
        <fmt:message key="prop.friends.newFriend" bundle="${resourceBundle}"/></title>
</head>
<body>
<p><fmt:message key="prop.friends.addFriend1" bundle="${resourceBundle}"/> ${sessionScope.nameOfAddingFriend}
    <fmt:message key="prop.friends.addFriend2" bundle="${resourceBundle}"/></p>

<form method="POST" action="../friends">
    <input class="b1" type="submit" name="confirmAdding" value="Да">
    <button class="b1"><a href="../friends"> Нет</a></button>
</form>
</body>
</html>
