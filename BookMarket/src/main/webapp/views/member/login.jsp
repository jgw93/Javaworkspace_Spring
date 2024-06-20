<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<h1 class="display-3">로그인</h1>
		</div>
	</div>
	<div class="container" align="center">
		<div class="col-md-4 col-md-offset4">
			<h3 class="form-signin-heading">Please sign in</h3>
			<%
		String error = request.getParameter("error");
		if(error != null){
			out.println("<div class='alert alert-danger'>");
			out.println("아이디와 비밀번호를 확인해주세요.");
			out.println("</div>");
		}
	%>
	<form class="form-signin" action="/member/login" method="post">
		<div class="form-group">
			<label for="inputUserName" class="sr-only">User Name</label>
			<input id="inputUserName" type="text" class="form-controll" placeholder="ID"
			name="memberID" required autofocus>
		</div>
		<div class="form-group">
			<label for="inputPassword" class="sr-only">Password</label>
			<input id="inputPassword" type="password" class="form-controll" placeholder="password"
			name="memberPW" required>
		</div>
		<button class="btn btn btn-lg btn-success btn-black" type="submit">로그인</button>
	</form>
		</div>
	</div>
	
	<jsp:include page="../footer.jsp" />
</body>
</html>