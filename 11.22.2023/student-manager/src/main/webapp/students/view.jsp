<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/24/2023
  Time: 9:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../style/style.css">
</head>
<body>
<a href="http://localhost:8080/students?action=findAll">
    <button>Quay lại trang chủ</button>
</a>
<h1>Thông tin sinh viên có ID = ${student.id}</h1>
<table border="1px">
    <tr>
        <td>ID</td>
        <td>Tên</td>
        <td>Ảnh</td>
    </tr>
    <tr>
        <td>${student.id}</td>
        <td>${student.name}</td>
        <td><img src="${student.image}"></td>
    </tr>
</table>
</body>
</html>
