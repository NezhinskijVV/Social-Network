<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/counterMessages.tld" prefix="countmess" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="../decoration/style.css" rel="stylesheet">
    <link href="../decoration/menu.css" rel="stylesheet">
    <title>Menu</title>
</head>
<body>
<fmt:setLocale value="${Locale.getDefault()}"/>
<fmt:setBundle basename="prop" var="resourceBundle"/>
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
    <%--todo: adding friends (+1)--%>
    <li>
        <button><a href="${pageContext.request.contextPath}/messages">
            <img src="../decoration/images/messages.jpg" alt="" style="vertical-align:middle">
            <fmt:message key="prop.messages" bundle="${resourceBundle}"/>
            <jsp:useBean id="count" class="java.lang.Object" scope="request"/>
            <countmess:counterMessages notReadMessages="${notReadMessages}"/>
        </button>
    </li>
    <li>
        <button><a href="${pageContext.request.contextPath}/dancers">
            <img src="../decoration/images/alldancers.jpg" alt="" style="vertical-align:middle">
            <fmt:message key="prop.alldancers" bundle="${resourceBundle}"/> </a></button>
    </li>
    <li>
        <button><a href="${pageContext.request.contextPath}/logout">
            <img src="../decoration/images/logout.jpg" alt="" style="vertical-align:middle">
            <fmt:message key="prop.logout" bundle="${resourceBundle}"/></a></button>
    </li>
    <li>
        <button><a href="${pageContext.request.contextPath}/change">
            <fmt:message key="prop.language" bundle="${resourceBundle}"/></a></button>
    </li>

</ul>
</body>
</html>
