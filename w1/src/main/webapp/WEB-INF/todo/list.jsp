<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 2024-04-03
  Time: 오후 3:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>

        table,td,th{
            border: 1px solid black;
            border-collapse: collapse;
        }
    </style>
</head>
<body>
    <h1>List Page</h1>
    <table>
        <tr>
            <th>TNO</th>
            <th>TITLE</th>
            <th>DUEDATE</th>
            <th>FINISHED</th>
        </tr>

    <c:forEach var="dto" items="${list}">
        <tr>
            <td>${dto.getTno()}</td>
            <td>${dto.getTitle()}</td>
            <td>${dto.getDueDate()}</td>
            <td>${dto.isFinished()}</td>
        </tr>
    </c:forEach>
    </table>
    <c:if test="${list.size() % 2 == 0}">
        짝수
    </c:if>
    <c:if test="${list.size() % 2 != 0}">
        홀수
    </c:if>
    <c:choose>
        <c:when test="${list.size() % 2 == 0}">
            짝수
        </c:when>
        <c:otherwise>
            홀수
        </c:otherwise>
    </c:choose>
    <c:set var="target" value="10"></c:set>
    <ul>
        <c:forEach var="num" begin="1" end="10">
            <c:if test = "${num == target}">
                    num is target
            </c:if>
        </c:forEach>
    </ul>
</body>
</html>
