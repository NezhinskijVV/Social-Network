<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        /*<!--position: fixed; !* Фиксированное положение *!-->*/
        /*<!--right: 10px; !* Расстояние от правого края окна браузера *!-->*/
        /*<!--top: 20%; !* Расстояние сверху *!-->*/
        /*<!--padding: 10px; !* Поля вокруг текста *!-->*/

        background: #006400;
        /*<!--border: 1px solid #333; !* Параметры рамки *!-->*/
        }
        ul.hr li {
            display: inline; /* Отображать как строчный элемент */
        }
        ul.hr button{
            background: #90EE90;
        }
    </style>
</head>
<body>
<ul class="hr">
    <li><button><a href="${pageContext.request.contextPath}/myPage">
        <img src="../decoration/images/mypage.jpg" alt="" style="vertical-align:middle">
         My page</a></button></li>
    <li><button><a href="${pageContext.request.contextPath}/friends">
        <img src="../decoration/images/friends.jpg" alt="" style="vertical-align:middle">
         Friends</a></button></li>
    <li><button><a href="${pageContext.request.contextPath}/messages">
        <img src="../decoration/images/messages.jpg" alt="" style="vertical-align:middle">

        Messages  + <%=request.getAttribute("notReadMessages")%> </button></li>
    <%--todo: without scriplet--%>
    <li><button><a href="${pageContext.request.contextPath}/dancers">
        <img src="../decoration/images/alldancers.jpg" alt="" style="vertical-align:middle">
        All dancers </a></button></li>
    <li><button><a href="${pageContext.request.contextPath}/logout">
        <img src="../decoration/images/logout.jpg" alt="" style="vertical-align:middle">
        Logout</a></button></li>
</ul>
</body>
</html>
