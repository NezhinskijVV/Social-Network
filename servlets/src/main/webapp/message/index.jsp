<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        ul.hr {
            /*margin: 0; !* Обнуляем значение отступов *!*/
            /*padding: 4px; !* Значение полей *!*/
            position: fixed; /* Фиксированное положение */
            right: 20px; /* Расстояние от правого края окна браузера */
            /*top: 20%; !* Расстояние сверху *!*/
            padding: 10px; /* Поля вокруг текста */
            background: #ffe; /* Цвет фона */
            border: 1px solid #333; /* Параметры рамки */
        }
        ul.hr li {
            display: inline; /* Отображать как строчный элемент */
        }
    </style>
</head>
<body>

<form method="POST" action="../send">
    <input type="text" name="message" autocomplete="off">
    <input type="submit" value="Enter">
</form>

</body>
</html>