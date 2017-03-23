<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="../decoration/style.css" rel="stylesheet">
    <title>Dancehall</title>
</head>
<body>
<fmt:setLocale value="${Locale.getDefault()}"/>
<fmt:setBundle basename="prop" var="resourceBundle"/>
<h1><fmt:message key="prop.style.dancehall.title" bundle="${resourceBundle}"/></h1>
<fmt:message key="prop.style.dancehall.text" bundle="${resourceBundle}"/>

<h2><fmt:message key="prop.style.dancehall.history" bundle="${resourceBundle}"/></h2>
<fmt:message key="prop.style.dancehall.text2" bundle="${resourceBundle}"/>

<h2><fmt:message key="prop.style.dancehall.teams" bundle="${resourceBundle}"/></h2>
<fmt:message key="prop.style.dancehall.text3" bundle="${resourceBundle}"/>
<br>
<br> <input type="button" class="b1" onclick="history.back();" value= "<fmt:message key="prop.style.back" bundle="${resourceBundle}"/>" />

</body>
</html>