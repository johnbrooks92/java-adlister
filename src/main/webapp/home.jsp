<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${title}</title>
</head>
<body>
<%@ include file="partials/navbar.jsp" %>
<h1>Hello Jupiter!</h1>

<p>The page number is: ${number}</p>

<c:choose>
    <c:when test="${isLoggedIn}">
        <h3>View Bob's Profile</h3>
        <form action="user-profile.jsp" method="get">
            <input type="hidden" id="username" name="username" value="Bob">
            <input type="hidden" id="user-id" name="user-id" value="12345">
            <button type="submit">Go There</button>
        </form>

        <h3>Add a To Do</h3>
        <form action="todo.jsp" method="post">
            <input type="text" id="item" name="item">
            <button type="submit">Add to List</button>
        </form>
    </c:when>
    <c:otherwise>
        <h3>Please log in first!</h3>
    </c:otherwise>
</c:choose>

<%@ include file="partials/footer.jsp" %>
</body>
</html>