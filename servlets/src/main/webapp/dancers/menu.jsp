<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/counterMessages.tld" prefix="countmess" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="prop" var="resourceBundle"/>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="../decoration/style.css" rel="stylesheet">
    <link href="../decoration/menu.css" rel="stylesheet">
    <title>Menu</title>
</head>
<body>

<ul class="hr">
    <li>
        <button><a href="${pageContext.request.contextPath}/myPage">
            <img src="../decoration/images/mypage.jpg" alt="" style="vertical-align:middle">
            <fmt:message key="prop.myPage" bundle="${resourceBundle}"/>
        </a></button>
    </li>
    <li>
        <button><a href="${pageContext.request.contextPath}/friends">
            <img src="../decoration/images/friends.jpg" alt="" style="vertical-align:middle">
            <fmt:message key="prop.friends" bundle="${resourceBundle}"/>
        </a></button>
    </li>
    <li>
        <button><a href="${pageContext.request.contextPath}/messages">
            <img src="../decoration/images/messages.jpg" alt="" style="vertical-align:middle">
            <fmt:message key="prop.messages" bundle="${resourceBundle}"/>
            <%--@elvariable id="notReadMessages" type="java.lang.Integer"--%>
            <countmess:counterMessages notReadMessages="${notReadMessages}"/>
        </button>
    </li>
    <li>
        <button><a href="${pageContext.request.contextPath}/dancers">
            <img src="../decoration/images/alldancers.jpg" alt="" style="vertical-align:middle">
            <fmt:message key="prop.allDancers" bundle="${resourceBundle}"/> </a></button>
    </li>
    <li>
        <button><a href="${pageContext.request.contextPath}/logout">
            <img src="../decoration/images/logout.jpg" alt="" style="vertical-align:middle">
            <fmt:message key="prop.logout" bundle="${resourceBundle}"/></a></button>
    </li>
    <li>
        <button class="language"><a href="${pageContext.request.contextPath}/change">
            <fmt:message key="prop.language" bundle="${resourceBundle}"/></a>
        </button>
    </li>

</ul>
</body>
</html>
