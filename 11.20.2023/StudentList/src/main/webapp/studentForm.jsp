<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/22/2023
  Time: 9:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sach sinh vien</h1>

<h2>Student Age > 25</h2>
<c:forEach var="student" items="${list}">
    <c:if test="${student.age > 25}">
        <h3>Id: ${student.id} | Name: ${student.name} | Age: ${student.age}</h3>
    </c:if>
</c:forEach>

<h2>Student Name Start With H</h2>
<c:forEach var="student" items="${list}">
    <c:if test="${student.name.startsWith('H')}">
        <h3>Id: ${student.id} | Name: ${student.name} | Age: ${student.age}</h3>
    </c:if>
</c:forEach>
</body>
</html>
