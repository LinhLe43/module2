<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/24/2023
  Time: 10:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="http://localhost:8080/students?action=findAll">
    <button>Quay lại trang chủ</button>
</a>
<p>Nhập tên sinh viên cần tìm</p>
<form action="students" method="post">
    <input type="hidden" name="action" value="search">
    <input type="text" name="name" placeholder="Nhập tên sinh viên">
    <button>Search</button>
</form>
</body>
</html>
