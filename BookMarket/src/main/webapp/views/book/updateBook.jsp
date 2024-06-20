<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>도서 수정</title>
	<link rel="stylesheet"
		  href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<script type="text/javascript" src="/resources/js/validation.js"></script>
</head>
<body>
<jsp:include page="../menu.jsp" />
<div class="jumbotron">
	<div class="container">
		<h1 class="display-3">도서 수정</h1>
	</div>
</div>
<div class="container">
	<div class="row">
		<div class="col-md-5">
			<img src="/imageFile/${book.imgFileName}" style="width:100%;" alt="image">
		</div>
		<div class="col-md-7">
			<form name="newBook" action="/book/updateBook" class="form-horizontal" method="post" enctype="multipart/form-data">
				<div class="form-group row">
					<label class="col-sm-2">도서 코드</label>
					<div class="col-sm-3">
						<input type="text" id="id" name="id" class="form-control" value="${book.id}" readonly>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2">도서명</label>
					<div class="col-sm-3">
						<input type="text" id="name" name="name" class="form-control" value="${book.name}">
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2">가격</label>
					<div class="col-sm-3">
						<input type="text" id="unitPrice" name="unitPrice" class="form-control" value="${book.unitPrice}">
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2">저자</label>
					<div class="col-sm-3">
						<input type="text" name="author" class="form-control" value="${book.author}">
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2">출판사</label>
					<div class="col-sm-3">
						<input type="text" name="publisher" class="form-control" value="${book.publisher}">
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2">출판일</label>
					<div class="col-sm-3">
						<input type="text" name="releaseDate" class="form-control" value="${book.releaseDate}">
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2">총 페이지 수</label>
					<div class="col-sm-3">
						<input type="text" id="totalPages" name="pages" class="form-control" value="${book.pages}">
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2">상세 설명</label>
					<div class="col-sm-7">
					<textarea name="description" class="form-control"
							  cols="100" rows="4">${book.description}
					</textarea>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2">분류</label>
					<div class="col-sm-3">
						<input type="text" name="category" class="form-control" value="${book.category}">
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2">재고수</label>
					<div class="col-sm-3">
						<input type="text" id="unitInStock" name="unitInStock" class="form-control" value="${book.unitInStock}">
					</div>
				</div>
<%--				<div class="form-group row">--%>
<%--					<label class="col-sm-2">상태</label>--%>
<%--					<div class="col-sm-5">--%>
<%--						<input type="radio" name="condition" value="New" ${book.condition=="New"?"checked":""}> 신규 도서--%>
<%--						<input type="radio" name="condition" value="Old" ${book.condition=="Old"?"checked":""}> 중고 도서--%>
<%--						<input type="radio" name="condition" value="E-Book" ${book.condition=="E-Book"?"checked":""}>  E-Book--%>
<%--					</div>--%>
<%--				</div>--%>
				<div class="form-group row">
					<label class="col-sm-2">이미지</label>
					<div class="col-sm-5">
						<input type="file" name="file" class="form-control">
					</div>
				</div>
				<div class="form-group row">
					<div class="col-sm-offset-2 col-sm-10">
						<input type="submit" class="btn btn-primary" value="수정">
						<%--					<input type="button" class="btn btn-primary" value="등록"--%>
						<%--						   onclick="CheckAddBook()">--%>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
<jsp:include page="../footer.jsp" />

</body>
</html>