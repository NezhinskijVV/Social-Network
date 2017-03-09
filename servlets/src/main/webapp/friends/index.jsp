<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link href="../decoration/style.css" rel="stylesheet">
    <title>Title</title>
</head>
<body>

<p>Хотите ли Вы добавить пользователя ${sessionScope.nameOfFriend} ${sessionScope.nameOfAddingFriend} в друзья?</p>
<%--<button><a href="../friends/confirmation.jsp"> Да</a></button>--%>
<%--<button><a href="../dancers"> Нет</a></button>--%>
<form method="POST" action="../friends">
    <input type="submit" class="b1" name="addFriend" value="Да">
    <button class="b1"><a href="../dancers"> Нет</a></button>
</form>

</body>
</html>
