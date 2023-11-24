<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/24/2023
  Time: 2:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../style/style.css">
</head>
<body>
<a href="http://localhost:8080/students?action=search">
    <button>Quay lại</button>
</a>
<table border="1px">
    <tr>
        <td>ID</td>
        <td>Tên</td>
        <td>Ảnh</td>
    </tr>
    <c:forEach var="item" items="${students}">
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td><img src="${item.image}"></td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
