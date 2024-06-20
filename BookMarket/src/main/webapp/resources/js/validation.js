/**
 * 
 */
function CheckAddBook() {
	var bookId = document.getElementById("bookId");
	var name = document.getElementById("name");
	var unitPrice = document.getElementById("unitPrice");
	var unitsInStock = document.getElementById("unitsInStock");
	var totalPage = document.getElementById("totalPages");

	//아이디
	if(!check(/^ISBN[0-9]{1,8}$/, bookId, "[도서 아이디]\nISBN와 숫자를 조합하여 5~12자까지 입력하세요\n 첫글자는 반드시 ISBN로 시작하세요."))
		return false;
	//이름
	if(name.value.length < 4 || name.value.length > 25){
		alert("[도서명]\n최소 4자에서 최대 25까지 입력하세요.")
		name.select();
		name.focus();
		return false;
	}
	//가격
	if(unitPrice.value == 0 || isNaN(unitPrice.value)){
		alert("[가격]\n숫자만 입력하세요.")
		unitPrice.select();
		unitPrice.focus();
		return false;
	}
	
	if(unitPrice.value < 0){
		alert("[가격]\n음수는 입력할 수 없습니다.")
		unitPrice.select();
		unitPrice.focus();
		return false;
	}else if(!check(/^\d+(>:[.][\d][\d])?$/,unitPrice,"[가격]\n소수점 둘째 자리까지만 입력하세요")){
		return false;
	}
	
	if(isNaN(unitsInStock.value)){
		alert("[재고]\n숫자만 입력하세요.")
		unitsInStock.select();
		unitsInStock.focus();
		return false;
	}
	
	if(isNaN(totalPage.value)){
		alert("[총 페이지 수]\n숫자만 입력하세요.")
		unitsInStock.select();
		unitsInStock.focus();
		return false;
	}
	
	function check(regExp, e, msg){
		if(regExp.test(e.value)){
			return true;
		}
		alert(msg);
		e.select();
		e.focus();
		return false;
	}
	
	document.newBook.submit();
}





