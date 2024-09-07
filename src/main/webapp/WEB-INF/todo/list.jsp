<%--
  Created by IntelliJ IDEA.
  User: laze
  Date: 2024. 9. 7.
  Time: 22:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Todo List</title>
</head>
<body>
<ul>
    <c:forEach items="${dtoList}" var="dto">
        <li>${dto}</li>
    </c:forEach>
</ul>
</body>
</html>
