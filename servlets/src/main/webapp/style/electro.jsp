<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="prop" var="resourceBundle"/>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="../decoration/style.css" rel="stylesheet">
    <title>Electro</title>
</head>
<body>
    <h1>
        <fmt:message key="prop.style.electro.title" bundle="${resourceBundle}"/>
    </h1>
    <h2>
        <fmt:message key="prop.style.electro.history" bundle="${resourceBundle}"/>
    </h2>
    <fmt:message key="prop.style.electro.text1" bundle="${resourceBundle}"/>
    <h2>
        <fmt:message key="prop.style.electro.etimology" bundle="${resourceBundle}"/>
    </h2>
    <fmt:message key="prop.style.electro.text2" bundle="${resourceBundle}"/>
    <h2>
        <fmt:message key="prop.style.electro.characteristic" bundle="${resourceBundle}"/>
    </h2>
    <fmt:message key="prop.style.electro.text3" bundle="${resourceBundle}"/>
    <br>
    <br> <input type="button" class="b1" onclick="history.back();" value= "<fmt:message key="prop.style.back" bundle="${resourceBundle}"/>" />
</body>
</html>