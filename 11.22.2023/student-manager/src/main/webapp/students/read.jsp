<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/23/2023
  Time: 2:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        img {
            width: 100px;
            height: 100px;
        }
    </style>
</head>
<body>
<h1>Danh sách sinh viên</h1>
<a href="http://localhost:8080/students?action=create">Thêm mới sinh viên</a>
<br>
<table border="1">
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Image</td>
        <td colspan="2">Action</td>
    </tr>
    <c:forEach var="item" items="${students}">
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td><img src="${item.image}"></td>
            <td><a href="http://localhost:8080/students?action=update&id=${item.id}"><button>Sửa</button></a></td>
            <td><a href="http://localhost:8080/students?action=delete&id=${item.id}"><button>Xóa</button></a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
