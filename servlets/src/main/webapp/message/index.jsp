<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="../decoration/style.css" rel="stylesheet">
    <title><fmt:setLocale value="${Locale.getDefault()}"/>
        <fmt:setBundle basename="prop" var="resourceBundle"/>
        <fmt:message key="prop.messages" bundle="${resourceBundle}"/>
    </title>
</head>
<body>

<form method="POST" action="">
    <input type="text" name="message" autocomplete="off">
    <input class="b1" type="submit" value="Enter">
    <button class="b1" onclick="history.back();"> Back</button>
    <button class="b1" type="submit" value="History" name="History"> History</button>
</form>

</body>
</html>