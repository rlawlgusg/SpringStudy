<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>부서목록</h2>
	<hr>
	<a href="insertDept.do">등록</a>
	<table>
		<tr>
			<td>부서번호</td>
			<td>부서이름</td>
			<td>부서위치</td>
		</tr>
		<c:forEach var="d" items="${list }">
		<tr>
			<td>${d.dno }</td>
			<td>${d.dname }</td>
			<td>${d.dloc }</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>