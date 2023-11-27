<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/23/2023
  Time: 4:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Thông tin sinh viên có ID = ${student.id}</p>
<a href="http://localhost:8080/students?action=findAll">
    <button>Quay lại trang chủ</button>
</a>
<br>
<form action="students" method="post">
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="oldId" value="${student.id}">
    <input type="number" name="newId" value="${student.id}">
    <br>
    <input type="text" name="name" value="${student.name}"><
    <br>
    <input type="text" name="image" value="${student.image}">
    <br>
    <input type="text" name="email" value="${student.email}">
    <br>
    <input type="number" name="age" value="${student.age}">
    <br>
    <button>Update</button>
</form>
</body>
</html>
