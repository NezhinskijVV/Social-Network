<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="../decoration/style.css" rel="stylesheet">
    <title>Hip Hop</title>
</head>
<body>
<fmt:setLocale value="${Locale.getDefault()}"/>
<fmt:setBundle basename="prop" var="resourceBundle"/>
<h1><fmt:message key="prop.style.hiphop.title" bundle="${resourceBundle}"/></h1>
<fmt:message key="prop.style.hiphop.text1" bundle="${resourceBundle}"/>
<h2><fmt:message key="prop.style.hiphop.oldschool" bundle="${resourceBundle}"/></h2>

<h3><fmt:message key="prop.style.hiphop.buddha" bundle="${resourceBundle}"/></h3>

<fmt:message key="prop.style.hiphop.text2" bundle="${resourceBundle}"/>

<br>
<h3><fmt:message key="prop.style.hiphop.henry" bundle="${resourceBundle}"/></h3>

<fmt:message key="prop.style.hiphop.text3" bundle="${resourceBundle}"/>

<br>
<h3><fmt:message key="prop.style.hiphop.buddha" bundle="${resourceBundle}"/></h3>

<fmt:message key="prop.style.hiphop.text4" bundle="${resourceBundle}"/>

<br><fmt:message key="prop.style.hiphop.oldmoves" bundle="${resourceBundle}"/>
<ul><li> <fmt:message key="prop.style.hiphop.oldmoves.smurf" bundle="${resourceBundle}"/></li>
<li> <fmt:message key="prop.style.hiphop.oldmoves.prep" bundle="${resourceBundle}"/>)</li>
<li> <fmt:message key="prop.style.hiphop.oldmoves.whop" bundle="${resourceBundle}"/></li>
<li> <fmt:message key="prop.style.hiphop.oldmoves.cabbage" bundle="${resourceBundle}"/></li>
<li> <fmt:message key="prop.style.hiphop.oldmoves.reebok" bundle="${resourceBundle}"/></li>
<li> <fmt:message key="prop.style.hiphop.oldmoves.fila" bundle="${resourceBundle}"/></li>
<li> <fmt:message key="prop.style.hiphop.oldmoves.happyfeat" bundle="${resourceBundle}"/></li></ul>


<br>
<h2><fmt:message key="prop.style.hiphop.middleschool" bundle="${resourceBundle}"/></h2>

<h3><fmt:message key="prop.style.hiphop.buddha" bundle="${resourceBundle}"/></h3>
<h3><fmt:message key="prop.style.hiphop.henry" bundle="${resourceBundle}"/></h3>

<fmt:message key="prop.style.hiphop.text5" bundle="${resourceBundle}"/>


<br><fmt:message key="prop.style.hiphop.middlemoves" bundle="${resourceBundle}"/>
<ul><li> <fmt:message key="prop.style.hiphop.middlemoves.partymachine" bundle="${resourceBundle}"/></li>
<li> <fmt:message key="prop.style.hiphop.middlemoves.runningman" bundle="${resourceBundle}"/></li>
<li> <fmt:message key="prop.style.hiphop.middlemoves.roger" bundle="${resourceBundle}"/></li>
<li> <fmt:message key="prop.style.hiphop.middlemoves.steve" bundle="${resourceBundle}"/></li>
<li> <fmt:message key="prop.style.hiphop.middlemoves.bart" bundle="${resourceBundle}"/></li>
<li> <fmt:message key="prop.style.hiphop.middlemoves.pepper" bundle="${resourceBundle}"/></li>
<li> <fmt:message key="prop.style.hiphop.middlemoves.bk" bundle="${resourceBundle}"/></li>
<li> <fmt:message key="prop.style.hiphop.middlemoves.buttlerfly" bundle="${resourceBundle}"/></li></ul>

<br>
<h2><fmt:message key="prop.style.hiphop.newschool" bundle="${resourceBundle}"/></h2>

<h3><fmt:message key="prop.style.hiphop.buddha" bundle="${resourceBundle}"/></h3>

<fmt:message key="prop.style.hiphop.text6" bundle="${resourceBundle}"/>


<br><fmt:message key="prop.style.hiphop.newschoolmoves" bundle="${resourceBundle}"/>
<ul>
<li> <fmt:message key="prop.style.hiphop.newschoolmoves.monestary" bundle="${resourceBundle}"/></li>
<li> <fmt:message key="prop.style.hiphop.newschoolmoves.cwalk" bundle="${resourceBundle}"/></li>
<li> <fmt:message key="prop.style.hiphop.newschoolmoves.bankheadbounce" bundle="${resourceBundle}"/></li>
<li> <fmt:message key="prop.style.hiphop.newschoolmoves.walkitout" bundle="${resourceBundle}"/></li>
<li> <fmt:message key="prop.style.hiphop.newschoolmoves.harlem" bundle="${resourceBundle}"/></li>
<li> <fmt:message key="prop.style.hiphop.newschoolmoves.atl" bundle="${resourceBundle}"/></li>
<li> <fmt:message key="prop.style.hiphop.newschoolmoves.tone" bundle="${resourceBundle}"/></li>
<li> <fmt:message key="prop.style.hiphop.newschoolmoves.wrecin" bundle="${resourceBundle}"/></li>
</ul>

<br>
<br> <input type="button" class="b1" onclick="history.back();" value= "<fmt:message key="prop.style.back" bundle="${resourceBundle}"/>" />


</body>
</html>