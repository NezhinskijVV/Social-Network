<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="prop" var="resourceBundle"/>
<html>
<head>
    <meta charset="UTF-8">
    <link href="../decoration/style.css" rel="stylesheet">
    <title>
        <fmt:message key="prop.friends" bundle="${resourceBundle}"/></title>
</head>
<body>
    <fmt:message key="prop.friends.questionPart1" bundle="${resourceBundle}"/>
    ${sessionScope.nameOfFriend} ${sessionScope.nameOfAddingFriend}
    <fmt:message key="prop.friends.questionPart2" bundle="${resourceBundle}"/>
    <form method="POST" action="../friends/">
        <input type="submit" class="b1" name="addFriend" value=<fmt:message key="prop.button.yes" bundle="${resourceBundle}"/>>
        <button class="b1">
            <a href="../dancers"> <fmt:message key="prop.button.no" bundle="${resourceBundle}"/></a>
        </button>
    </form>
</body>
</html>
