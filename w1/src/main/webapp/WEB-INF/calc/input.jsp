<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 2024-04-03
  Time: 오전 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/calc/makeResult" method="POST">
        <input type="number" name="num1">
        <input type="number" name="num2">
        <button type="submit">SEND</button>
    </form>
</body>
</html>
