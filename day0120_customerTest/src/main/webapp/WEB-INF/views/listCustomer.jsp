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

<h2>�����</h2>
	<hr>
	<a href="insertCustomer.do">���</a> <br>
	<table border="1" width="80%">
		<tr>
			<th>����ȣ</th>
			<th>����</th>
		
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