<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>To Do List</title>
</head>
<body>
<c:if test="${isAdmin}">
    <%@ include file="partials/admin-nav.jsp" %>
</c:if>

<h1>Here is your To Do List:</h1>
<ul>
    <c:forEach items="${myTasks}" var="task">
        <li>${task}</li>
    </c:forEach>
</ul>

<p><%= request.getMethod() %>
</p>
<p>${header}</p>
</body>
</html>