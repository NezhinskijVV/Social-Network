<%--
  Created by IntelliJ IDEA.
  User: Detalya
  Date: 21.01.2017
  Time: 9:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<p>Хотите ли Вы добавить пользователя ${sessionScope.nameOfFriend} ${sessionScope.nameOfAddingFriend} в друзья?</p>
<%--<button><a href="../friends/confirmation.jsp"> Да</a></button>--%>
<%--<button><a href="../dancers"> Нет</a></button>--%>
<form method="POST" action="../friends">
    <input type="submit" name="addFriend" value="Да">
    <button><a href="../dancers"> Нет</a></button>
</form>

</body>
</html>
