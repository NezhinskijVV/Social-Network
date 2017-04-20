<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/dancers.tld" prefix="dancers" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="prop" var="resourceBundle"/>

<html>
<head>
    <meta charset="UTF-8">
    <link href="../decoration/style.css" rel="stylesheet">
    <title>
        <fmt:message key="prop.allDancers" bundle="${resourceBundle}"/>
    </title>
</head>
<body>
    <%@ include file="menu.jsp" %>
    <jsp:useBean id="dancers" class="java.util.HashSet" scope="request"/>
    <table>
        <tr>
            <th><fmt:message key="prop.alldancers.dancer" bundle="${resourceBundle}"/></th>
            <th><fmt:message key="prop.alldancers.style" bundle="${resourceBundle}"/></th>
        </tr>
        <dancers:list dancers="${dancers}"/>
    </table>
</body>
</html>