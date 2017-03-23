<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="../decoration/style.css" rel="stylesheet">
    <title>Rumba</title>
</head>
<body>
<fmt:setLocale value="${Locale.getDefault()}"/>
<fmt:setBundle basename="prop" var="resourceBundle"/>
<h1><fmt:message key="prop.style.rumba.title" bundle="${resourceBundle}"/></h1>

<h2><fmt:message key="prop.style.rumba.history" bundle="${resourceBundle}"/></h2>
<fmt:message key="prop.style.rumba.text1" bundle="${resourceBundle}"/>


<h2><fmt:message key="prop.style.rumba.features" bundle="${resourceBundle}"/></h2>
<fmt:message key="prop.style.rumba.text2" bundle="${resourceBundle}"/>

<ul>
    <li> <fmt:message key="prop.style.rumba.forward" bundle="${resourceBundle}"/></li>

    <fmt:message key="prop.style.rumba.text3" bundle="${resourceBundle}"/>

    <li> <fmt:message key="prop.style.rumba.back" bundle="${resourceBundle}"/> </li>

    <fmt:message key="prop.style.rumba.text4" bundle="${resourceBundle}"/>
    </ul>

<fmt:message key="prop.style.rumba.text5" bundle="${resourceBundle}"/>
    <br>
<br> <input type="button" class="b1" onclick="history.back();" value= "<fmt:message key="prop.style.back" bundle="${resourceBundle}"/>" />

</body>
</html>