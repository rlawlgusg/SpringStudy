<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>상품상세</h2>
	<hr>
	상품번호 : ${g.no } <br>
	상품이름 : ${g.name } <br>
	상품가격 : ${g.price } <br>
	상품수량 : ${g.qty } <br>
	<img src="images/${g.fname }" width="100" height="100">
	<br>
	<a href="updateGoods.do?no=${g.no}">상품수정</a>
	<a href="deleteGoods.do?no=${g.no}">상품삭제</a>
</body>
</html>