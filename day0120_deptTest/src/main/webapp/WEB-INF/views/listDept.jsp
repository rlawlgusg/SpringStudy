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
	<h2>�μ����</h2>
	<hr>
	<a href="insertDept.do">���</a> <br>
	<table border="1" width="80%">
		<tr>
			<th>�μ���ȣ</th>
			
		</tr>
		<c:forEach var="d" items="${list}">
			<tr>
				<td><a href="detailDept.do?dno=${d.dno}">${d.dno }</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>