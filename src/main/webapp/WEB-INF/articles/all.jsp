<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    <%@include file='/WEB-INF/css/main.css' %>
</style>
<html>
<head>
    <title>All articles</title>
</head>
<body>
<h1 class="table_dark">All articles:</h1>
<table border="1" class="table_dark">
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Content</th>
        <th>Author name</th>
        <th>Date</th>
    </tr>
    <c:forEach var="article" items="${articles}">
        <tr>
            <td>
                <c:out value="${article.id}"/>
            </td>
            <td>
                <c:out value="${article.title}"/>
            </td>
            <td>
                <c:out value="${article.content}"/>
            </td>
            <td>
                <c:out value="${article.author.name}"/>
            </td>
            <td>
                <c:out value="${article.date}"/>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/drivers/delete?id=${driver.id}">DELETE</a>
            </td>
        </tr>
    </c:forEach>
</table>
<h4><a href="${pageContext.request.contextPath}/articles/add">Add new article</a></h4>
</body>
</html>