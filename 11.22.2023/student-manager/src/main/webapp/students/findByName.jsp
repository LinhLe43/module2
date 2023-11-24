<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/24/2023
  Time: 10:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Nhập tên sinh viên cần tìm</p>
<form action="students" method="get">
    <input type="hidden" name="action" value="findByName">
    <input type="text" name="name" placeholder="Nhập tên">
    <button>Tìm kiếm</button>
</form>
</body>
</html>
