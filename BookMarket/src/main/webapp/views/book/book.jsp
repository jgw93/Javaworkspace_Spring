<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>도서 상세 정보</title>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<script type="text/javascript">
	function addToCart(){
		if(confirm("상품을 장바구니에 추가하시겠습니까?")){
			document.addForm.submit();
		} else{
			document.addForm.reset();
		}
	}
</script>
</head>
<body>
	<jsp:include page="../menu.jsp" />
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">도서 정보</h1>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-5">
				<img src="/imageFile/${book.imgFileName}" style="width:100%;" alt="" >
			</div>
			<div class="col-md-6">
				<h3>${book.name}</h3>
				<p>${book.description}</p>
				<p><b>도서 코드 : </b>
					<span class="badge badge-danger">
						${book.id}
					</span>
				</p>
				<p><b>출판사</b> : ${book.publisher}</p>
				<p><b>저자</b> : ${book.author}</p>
				<p><b>재고수</b> : ${book.unitInStock}</p>
				<p><b>총 페이지수</b> : ${book.pages}</p>
				<p><b>출판일</b> : ${book.releaseDate}</p>
				<h4>${book.unitPrice}원</h4>
				<p>
					<form name="addForm" method="post" action="./view/order/addCart.jsp?id=${book.id}">
						<a href="#" class="btn btn-info" onclick="addToCart()">도서 주문 &raquo;</a>
						<a href="./view/order/cart.jsp" class="btn btn-warning">장바구니 &raquo;</a>
						<a href="/book/books" class="btn btn-secondary">도서 목록 &raquo;</a>
					</form>
				</p>
			</div>
		</div>
		<hr>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>







