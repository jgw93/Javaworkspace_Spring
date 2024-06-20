<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>도서 편집</title>
	<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
	<script type="text/javascript">
		function deleteConfirm(id){
			if(confirm("해당 상품을 삭제합니다!!")==true){
				location.href="/book/remove?id=" + id;
			}else{
				return;
			}
		}
	</script>
</head>
<body>
<jsp:include page="../menu.jsp" />
<div class="jumbotron">
	<div class="container">
		<h1 class="display-3">도서 편집</h1>
	</div>
</div>
<div class="container">
	<div class="row" align="center">
		<c:forEach items="${books}" var="book">
			<div class="col-md-4">
				<img src="/imageFile/${book.imgFileName}" style="width:100%;" alt="">
				<h3>${book.name}</h3>
				<p>${book.description}</p>
				<p>${book.unitPrice}원</p>
				<p>
					<a href="/book/updateBook?id=${book.id}" class="btn btn-success" role="button">수정 &raquo;</a>
					<a href="#" onclick="deleteConfirm('${book.id}')" class="btn btn-danger" role="button">삭제 &raquo;</a>
				</p>
			</div>
		</c:forEach>
	</div>
	<hr>
</div>
<jsp:include page="../footer.jsp" />
</body>
</html>
















