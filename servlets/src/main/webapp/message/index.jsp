<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="prop" var="resourceBundle"/>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="../decoration/style.css" rel="stylesheet">
    <title>
        <fmt:message key="prop.messages" bundle="${resourceBundle}"/>
    </title>
</head>
<body>

<form method="post" action="">
    <input type="text" name="message" autocomplete="off">
    <input class="b1" type="submit" value="Enter" name="Enter">
    <button class="b1"><a href="../friends"> <fmt:message key="prop.button.toFriends" bundle="${resourceBundle}"/></a>
    </button>
    <button class="b1" type="submit" value="History" name="History"><fmt:message key="prop.button.history" bundle="${resourceBundle}"/></button>
</form>


<c:forEach var="i" begin="1" end="${quantityOfPages - 1}">
    <div class="item-list">
        <ul class="pager">
            <c:if test="${param.page}">
                <li><span>${i}</span></li>
            </c:if>
            <c:if test="${quantityOfPages > 1}">
                <c:if test="${!param.page}">
                    <li>
                        <a href="${pageContext.request.requestURL}?id=${pageContext.request.getParameter("id")}&page=${i}">${i}</a>
                    </li>
                </c:if>
            </c:if>
        </ul>
    </div>
</c:forEach>
<c:if test="${!param.page}">
    <li><a href="${pageContext.request.requestURL}?id=${pageContext.request.getParameter("id")}">${quantityOfPages}</a>
    </li>
</c:if>

</body>
</html>