<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    <%@include file='/WEB-INF/css/main.css' %>
</style>
<html>
<head>
    <title>Add articles</title>
</head>
<body>
<form method="post" id="article" action="${pageContext.request.contextPath}/articles/add" modelAttribute="articleForm"></form>
<h1 class="table_dark">Add articles</h1>
<table border="1" class="table_dark">
    <tr>
        <th>Title</th>
        <th>Content</th>
        <th>Add</th>
    </tr>
    <tr>
        <td>
            <input type="text" name="title" form="article" required>
        </td>
        <td>
            <input type="text" name="content" form="article" required>
        </td>
        <td>
            <input type="submit" name="add" form="article">
        </td>
    </tr>
</table>
</body>
</html>