<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link href="../decoration/style.css" rel="stylesheet">
    <title>
        <fmt:setLocale value="${Locale.getDefault()}"/>
        <fmt:setBundle basename="prop" var="resourceBundle"/>
        <fmt:message key="prop.friends.request" bundle="${resourceBundle}"/></title>
</head>
<body>

<p><fmt:message key="prop.friends.questionPart1" bundle="${resourceBundle}"/>
     ${sessionScope.nameOfFriend} ${sessionScope.nameOfAddingFriend}
    <fmt:message key="prop.friends.questionPart2" bundle="${resourceBundle}"/>
</p>

<form method="POST" action="../friends">
    <input type="submit" class="b1" name="addFriend" value="Да">
    <button class="b1"><a href="../dancers"> Нет</a></button>
</form>

</body>
</html>
