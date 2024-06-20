<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 등록</title>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<script type="text/javascript" src="/resources/js/validation.js"></script>
</head>
<body>
	<jsp:include page="../menu.jsp" />
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">도서 등록</h1>
		</div>
	</div>
	<div class="container">
		<form name="newBook" action="/book/addBook" class="form-horizontal" method="post" enctype="multipart/form-data">
			<div class="form-group row">
				<label class="col-sm-2">도서 코드</label>
				<div class="col-sm-3">
					<input type="text" id="id" name="id" class="form-control" value="ISBN1237">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">도서명</label>
				<div class="col-sm-3">
					<input type="text" id="name" name="name" class="form-control" value="파이썬 정복">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">가격</label>
				<div class="col-sm-3">
					<input type="text" id="unitPrice" name="unitPrice" class="form-control" value="19800">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">저자</label>
				<div class="col-sm-3">
					<input type="text" name="author" class="form-control" value="김상형">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">출판사</label>
				<div class="col-sm-3">
					<input type="text" name="publisher" class="form-control" value="한빛아카데미">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">출판일</label>
				<div class="col-sm-3">
					<input type="text" name="releaseDate" class="form-control" value="2018-04-02">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">총 페이지 수</label>
				<div class="col-sm-3">
					<input type="text" id="totalPages" name="pages" class="form-control" value="509">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">상세 설명</label>
				<div class="col-sm-7">
					<textarea name="description" class="form-control" 
					cols="100" rows="4">이 책은 프로그래밍을 처음 접하는 독자들 대상으로 한 파이썬 입문서입니다. 프로그래밍에 대한 경험이 전혀 없어도 목차에 따라 문법을 익히고, 실습을 진행하면 파이썬을 쉡게 배울 수 있습니다.
					</textarea>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">분류</label>
				<div class="col-sm-3">
					<input type="text" name="category" class="form-control" value="IT 모바일">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">재고수</label>
				<div class="col-sm-3">
					<input type="text" id="unitInStock" name="unitInStock" class="form-control" value="200">
				</div>
			</div>
<%--			<div class="form-group row">--%>
<%--				<label class="col-sm-2">상태</label>--%>
<%--				<div class="col-sm-5">--%>
<%--					<input type="radio"  name="condition" value="New" checked>신규 도서--%>
<%--					<input type="radio"  name="condition" value="Old" > 중고 도서--%>
<%--					<input type="radio"  name="condition" value="E-Book">  E-Book--%>
<%--				</div>--%>
<%--			</div>--%>
			<div class="form-group row">
				<label class="col-sm-2">이미지</label>
				<div class="col-sm-5">
					<input type="file" name="imageFile" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="submit" class="btn btn-primary" value="등록">
<%--					<input type="button" class="btn btn-primary" value="등록"--%>
<%--						   onclick="CheckAddBook()">--%>
				</div>
			</div>
		</form>
	</div>
	<jsp:include page="../footer.jsp" />
	
</body>
</html>








