<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="prop" var="resourceBundle"/>
<html>
<head>
    <meta charset="UTF-8">
    <link href="../decoration/style.css" rel="stylesheet">
    <title>
        <fmt:message key="prop.friends.newFriend" bundle="${resourceBundle}"/></title>
</head>
<body>
    <p>
        <fmt:message key="prop.friends.addFriend1" bundle="${resourceBundle}"/> ${sessionScope.nameOfAddingFriend}
        <fmt:message key="prop.friends.addFriend2" bundle="${resourceBundle}"/>
    </p>

    <form method="POST" action="../friends">
        <input class="b1" type="submit" name="confirmAdding" value=<fmt:message key="prop.button.yes" bundle="${resourceBundle}"/>>
        <button class="b1"><a href="../friends"> <fmt:message key="prop.button.no" bundle="${resourceBundle}"/></a></button>
    </form>
</body>
</html>
