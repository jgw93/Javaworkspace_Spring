<%--
  Created by IntelliJ IDEA.
  User: mydf4
  Date: 2024-05-01
  Time: 오전 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="../menu.jsp" />
<div class="jumbotron">
    <div class="container">
        <h1 class="display-3">회원가입</h1>
    </div>
</div>
<div class="container">
    <form name="newMember" action="/member/join" class="form-horizontal" method="post" enctype="multipart/form-data">
        <div class="form-group row">
            <label class="col-sm-2">아이디</label>
            <div class="col-sm-3">
                <input type="text" id="id" name="memberID" class="form-control">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2">비밀번호</label>
            <div class="col-sm-3">
                <input type="text" id="pw" name="memberPW" class="form-control">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2">이름</label>
            <div class="col-sm-3">
                <input type="text" id="name" name="memberName" class="form-control">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2">휴대전화</label>
            <div class="col-sm-3">
                <input type="text" id="phone" name="phone" class="form-control">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2">EMAIL</label>
            <div class="col-sm-3">
                <input type="text" name="email" class="form-control">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2">주소</label>
            <div class="col-sm-3">
                <input type="text" name="address" class="form-control">
            </div>
        </div>
        <div class="form-group row">
            <div class="col-sm-offset-2 col-sm-10">
                <input type="submit" class="btn btn-primary" value="회원가입">
            </div>
        </div>
    </form>
</div>
<jsp:include page="../footer.jsp" />
</body>
</html>
