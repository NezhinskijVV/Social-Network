<%--
  Created by IntelliJ IDEA.
  User: Detalya
  Date: 21.01.2017
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link href="../decoration/style.css" rel="stylesheet">
    <title>New friend</title>
</head>
<body>
<p>Вас хочет добавить  ${sessionScope.nameOfAddingFriend} в друзья. Принять заявку?</p>
<%--<button><a href="/friends/confirmation.jsp"> Да</a></button>--%>
<%--<button><a href="/dancers"> Нет</a></button>--%>
<form method="POST" action="../friends">
    <input class="b1" type="submit" name="confirmAdding" value="Да">
    <button class="b1"><a href="../friends"> Нет</a></button>
</form>
</body>
</html>
