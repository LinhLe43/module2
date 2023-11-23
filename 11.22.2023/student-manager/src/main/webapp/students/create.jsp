<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/23/2023
  Time: 2:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Thêm mới sinh viên</h1>
<a href="http://localhost:8080/students?action=findAll">Quay lại trang chủ</a>
<br>
<form action="students" method="post">
    <input type="hidden" name="action" value="create">
    <input type="number" name="id" placeholder="Nhập id">
    <br>
    <input type="text" name="name" placeholder="Nhập tên">
    <br>
    <input type="text" name="image" placeholder="Nhập link ảnh">
    <br>
    <button>Add</button>
</form>
</body>
</html>
