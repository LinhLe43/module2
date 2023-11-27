<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/23/2023
  Time: 3:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Bạn có muốn xóa sinh viên có ID = ${student.id} và tên là: ${student.name} hay không ?</p>
<form action="students" method="post">
    <input type="hidden" name="action" value="delete">
    <input type="hidden" name="id" value="${student.id}">
    <button>Có</button>
</form>
<a href="http://localhost:8080/students?action=findAll"><button>Không</button></a>
</body>
</html>
