<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/styles.tld" prefix="styles" %>


<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="../decoration/style.css" rel="stylesheet">
    <meta charset="UTF-8">
    <style>
        BODY {
            background-color: #b8edb9;
            font-family: Verdana, serif;
            font-size: 14pt;
        }

        a {
            text-decoration: none;
            color: white;
        }

        p {
            margin-top: 0.5em; /* Отступ сверху */
            margin-bottom: 0.5em; /* Отступ снизу */
        }

        .b1 {
            background: #006400;
            color: white;
            font-size: 16pt;
            padding: 3px;
            width: 120px;
            height: 30px;
        }
    </style>
    <title>Registration</title>
</head>
<body>
<form method="POST" action="../register">
    <label>First name:
        <input type="text" name="name" required pattern="^[a-zA-Z]+$"></label>
    <p><label>Surname:
        <input type="text" name="surname" required pattern="^[a-zA-Z]+$"></label></p>
    <p><label>Date of birth:
        <input type="date" name="dob" required></label></p>
    <p><label>Nickname:
        <input type="text" name="nickname" required></label></p>
    <p><label>Email:
        <input type="email" name="email" required autocomplete="off"></label></p>
    <p><label>Password:
        <input type="password" name="password" autocomplete="off" required></label></p>
    <p><label>Confirm password:
        <input type="password" name="confirmpassword" autocomplete="off" required></label></p>
    <p><label>Telephone:
        <input type="text" name="telephone" pattern="^[ 0-9]+$" required></label></p>
    <p>Style:</p>
    <jsp:useBean id="styles" class="java.util.HashSet" scope="request"/>
    <styles:list styles="${styles}"/>
    <p><input class="b1" type="submit" value="Register"></p>
</form>
</body>
</html>