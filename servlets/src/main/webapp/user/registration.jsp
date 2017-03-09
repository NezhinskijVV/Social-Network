<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="../decoration/style.css" rel="stylesheet">
    <meta charset="UTF-8">
    <style>
        BODY{
            background-color: #b8edb9;
            font-family: Verdana, serif;
            font-size: 14pt;
        }
        a{
            text-decoration: none;
            color: white;
        }
        p {
            margin-top: 0.5em; /* Отступ сверху */
            margin-bottom: 0.5em; /* Отступ снизу */
        }
        .b1 {
            background:  #006400;
            color: white;
            font-size: 16pt;
            padding: 3px;
            width: 120px;
            height:30px;
        }
    </style>
    <title>Registration</title>
</head>
<body>
<form method="POST" action="../register">
    <p>FirstName:</p>
    <input type="text" name="name" required pattern="^[a-zA-Z]+$">
    <p>Surname:</p>
    <input type="text" name="surname" required pattern="^[a-zA-Z]+$" >
    <p>Date of birth:</p>
    <input type="date" name="dob" required>
    <p>Nickname:</p>
    <input type="text" name="nickname" required >
    <p>Email:</p>
    <input type="email" name="email" required autocomplete="off">
    <p>Password:</p>
    <input type="password" name="password" autocomplete="off" required>
    <p>Confirm password:</p>
    <input type="password" name="confirmpassword" autocomplete="off" required>
    <p>Telephone:</p>
    <input type="text" name="telephone" pattern="^[ 0-9]+$" required>
    <p>Style:</p>
    <!--todo взаимодействие с базой-->
    <%--<jsp:useBean id="styles" class="java.util.HashSet" scope="request"/>--%>
    <%--<table>--%>
        <%--<stylesOfDance:list styles="${styles}"/>--%>
    <%--</table>--%>
    <%--<input type="radio" name="option" value="2" >electro<br>--%>
    <%--<input type="radio" name="option" value="3" >popping<br>--%>
    <%--<input type="radio" name="option" value="4" >dancehall<br>--%>
    <%--<input type="radio" name="option" value="5" >locking<br>--%>
    <%--<input type="radio" name="option" value="6" >rumba<br>--%>
    <p><input class="b1" type="submit" value="Register"></p>
</form>
</body>
</html>