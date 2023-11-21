<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/21/2023
  Time: 11:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<form action="/cal" method="post">
    <input type="text" placeholder="Input first number" name="firstNumber">
    <br>
    <select name="operation">
        <option value="+">Addition</option>
        <option value="-">Subtraction</option>
        <option value="*">Multiplication</option>
        <option value="/">Division</option>
    </select>
    <br>
    <input type="text" placeholder="Input second number" name="secondNumber">
    <br>
    <button>Calculate</button>
</form>
</body>
</html>
