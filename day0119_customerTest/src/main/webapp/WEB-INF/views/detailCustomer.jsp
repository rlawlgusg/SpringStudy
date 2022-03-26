<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>고객 상세</h2>
	<hr>
	고객번호 : ${c.custid } <br>
	고객이름 : ${c.name } <br>
	고객주소 : ${c.address } <br>
	고객전화 : ${c.phone } <br>
	<hr>
	<a href="updateCustomer.do?custid=${c.custid }">수정</a>
	<a href="deleteCustomer.do?custid=${c.custid }">삭제</a>
</body>
</html>