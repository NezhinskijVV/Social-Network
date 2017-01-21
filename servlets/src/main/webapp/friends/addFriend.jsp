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
    <title>New friend</title>
</head>
<body>
<p>Хотите ли Вы добавить пользователя ${sessionScope.name_of_friend} в друзья?</p>
<%--<button><a href="/friends/confirmation.jsp"> Да</a></button>--%>
<%--<button><a href="/dancers"> Нет</a></button>--%>
<form method="POST" action="../friends">
    <input type="button" name="addFriend" autocomplete="off">
    <input type="submit" value="Да">
    <button><a href="../dancers"> Нет</a></button>
</form>
</body>
</html>
