<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/styles.tld" prefix="stylesOfDance"%>

<html>
<head>
    <title>Танцевальные стили</title>
</head>
<body>
<jsp:useBean id="styles" class="java.util.HashSet" scope="request"/>
<table>
    <tr>
        <th>style</th>
        <th>isClassicalDance</th>
    </tr>
    <stylesOfDance:list styles="${styles}"/>
</table>
</body>
</html>