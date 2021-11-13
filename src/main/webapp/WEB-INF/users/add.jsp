<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    <%@include file='/WEB-INF/css/main.css' %>
</style>
<html>
<head>
    <title>Register user</title>
</head>
<body>
<form method="post" id="user" action="${pageContext.request.contextPath}/register" modelAttribute="userForm"></form>
<h1 class="table_dark">Register user</h1>
<table border="1" class="table_dark">
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Password</th>
        <th>Add</th>
    </tr>
    <tr>
        <td>
            <input type="text" name="name" form="user" required>
        </td>
        <td>
            <input type="text" name="email" form="user" required>
        </td>
        <td>
            <input type="password" name="password" form="user" required>
        </td>
        <td>
            <input type="submit" name="add" form="user">
        </td>
    </tr>
</table>
</body>
</html>