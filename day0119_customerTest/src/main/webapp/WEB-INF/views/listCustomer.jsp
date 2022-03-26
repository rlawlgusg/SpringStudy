<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<h2>고객목록</h2>
	<hr>
	<a href="insertCustomer.do">등록</a> <br>
	<table border="1" width="80%">
		<tr>
			<th>고객번호</th>
			<th>고객명</th>
		
		</tr>
		<c:forEach var="c" items="${list}">
			<tr>
				<td>${c.custid }</td>
				<td>
				<a href="detailCustomer.do?custid=${c.custid }">${c.name }</a>
				</td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>