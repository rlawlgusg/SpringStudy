<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="insertBoard.do">게시판 등록</a>

<h2>게시판 목록</h2>
<table border="1" width="80%">
	<tr>
		<td>게시판 번호</td>
		<td>게시판 제목</td>
		<td>게시판 작성자</td>
	</tr>
	<c:forEach var="b" items="${list }">
		<tr>
			<td>${b.no }</td>
			<td>${b.title }</td>
			<td>${b.writer }</td>			
		</tr>
	</c:forEach>
</table>

</body>
</html>