<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="prop" var="resourceBundle"/>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="../decoration/style.css" rel="stylesheet">
    <title>Popping</title>
</head>
<body>
    <h1>
        <fmt:message key="prop.style.popping.title" bundle="${resourceBundle}"/>
    </h1>
    <fmt:message key="prop.style.popping.text1" bundle="${resourceBundle}"/>
    <h2>
        <fmt:message key="prop.style.popping.history" bundle="${resourceBundle}"/>
    </h2>
    <fmt:message key="prop.style.popping.text2" bundle="${resourceBundle}"/>
    <ul>
        <li>Boogaloo Sam</li>
        <li>Slide (Nate)</li>
        <li>Robot Joe</li>
        <li>Toyman Skeet</li>
        <li>Tickin Will</li>
        <li>Twist-O-Flex Don</li>
        <li>Ant Man</li>
    </ul>
    <fmt:message key="prop.style.popping.text3" bundle="${resourceBundle}"/>
    <ul>
        <li>Boogaloo Sam</li>
        <li>Popin Pete</li>
        <li>Tickin Deck</li>
        <li>Robot Dane</li>
        <li>Puppet Boozer</li>
        <li>Creepin Sid</li>
        <li>Scarecrow Sculley</li>
        <li>Darryl (King Cobra)</li>
        <li>Geogre (King Rattler)</li>
    </ul>
    <h2>
        <fmt:message key="prop.style.popping.popularity" bundle="${resourceBundle}"/>
    </h2>
    <fmt:message key="prop.style.popping.text4" bundle="${resourceBundle}"/>
    <h2>
        <fmt:message key="prop.style.popping.falling" bundle="${resourceBundle}"/>
    </h2>
    <fmt:message key="prop.style.popping.text5" bundle="${resourceBundle}"/>
    <h2>
        <fmt:message key="prop.style.popping.rebirth" bundle="${resourceBundle}"/>
    </h2>
    <fmt:message key="prop.style.popping.text6" bundle="${resourceBundle}"/>
    <ul>
        <li>Boogaloo Sam</li>
        <li>Popin` Pete</li>
        <li>Skeeter Rabbit</li>
        <li>Suga Pop</li>
        <li>Mr.Wiggles</li>
        <li>Jazzy J</li>
        <li>Shonn Boog</li>
    </ul>
    <br>
    <br> <input type="button" class="b1" onclick="history.back();" value= "<fmt:message key="prop.style.back" bundle="${resourceBundle}"/>" />
</body>
</html>