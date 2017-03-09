<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/counterMessages.tld" prefix="countmess" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="../decoration/style.css" rel="stylesheet">
    <title>Menu</title>
    <style>
        ul.hr {
            text-decoration: none;
            margin: 0; /* Обнуляем значение отступов */
            padding: 4px; /* Значение полей */
            background: #006400;
        }

        ul.hr li {
            display: inline; /* Отображать как строчный элемент */
        }
        ul.hr a{
            text-align: left;
        }

        ul.hr button {
            text-align: left;
            background: #90EE90;
            width: 220px;
            height:120px;
        }
    </style>
</head>
<body>
<ul class="hr">
    <li>
        <button><a href="${pageContext.request.contextPath}/myPage">
            <img src="../decoration/images/mypage.jpg" alt="" style="vertical-align:middle">
            My page</a></button>
    </li>
    <li>
        <button><a href="${pageContext.request.contextPath}/friends">
            <img src="../decoration/images/friends.jpg" alt="" style="vertical-align:middle">
            Friends
        </a></button>
    </li>
    <%--todo: adding friends (+1)--%>
    <li>
        <button><a href="${pageContext.request.contextPath}/messages">
            <img src="../decoration/images/messages.jpg" alt="" style="vertical-align:middle">
            Messages
            <jsp:useBean id="count" class="java.lang.Object" scope="request"/>
                <countmess:counterMessages notReadMessages="${notReadMessages}"/>
        </button>
    </li>
    <li>
        <button><a href="${pageContext.request.contextPath}/dancers">
            <img src="../decoration/images/alldancers.jpg" alt="" style="vertical-align:middle">
            All dancers </a></button>
    </li>
    <li>
        <button><a href="${pageContext.request.contextPath}/logout">
            <img src="../decoration/images/logout.jpg" alt="" style="vertical-align:middle">
            Logout</a></button>
    </li>
</ul>
</body>
</html>
