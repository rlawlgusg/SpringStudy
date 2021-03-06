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
<h2>게시물 목록</h2>
<c:if test="${not empty member }">
	${member.name}님 로그인 하였습니다.
	<a href="listBoard?writer=${member.id}">나의 글</a>
	<a href="listBoard?writer=all">모든 글</a>
</c:if>
<c:if test="${empty member }">
	<a href="login">로그인</a>
</c:if>
<br>

<a href="insertBoard">게시물 등록</a>
<form action="listBoard" method="post">
	<select name="searchColumn">
		<option value="title">제목</option>
		<option value="content">내용</option>
		<option value="writer">작성자</option>
	</select>
	<input type="search" name="keyword">
	<input type="submit" value="검색">
</form>
<table border="1">
	<tr>
		<td><a href="listBoard?orderColumn=no">글번호</a></td>
		<td><a href="listBoard?orderColumn=title">글제목</a></td>
		<td><a href="listBoard?orderColumn=writer">작성자</a></td>
		<td><a href="listBoard?orderColumn=hit">조회수</a></td>
		<td><a href="listBoard?orderColumn=ip">ip</a></td>
	</tr>
	<c:forEach var="b" items="${list }">
		<tr>
			<td>${b.no }</td>
			<td><a href="detailBoard?no=${b.no }">${b.title }</a></td>
			<td>${b.writer }</td>
			<td>${b.hit }</td>
			<td>${b.ip }</td>
		</tr>
	</c:forEach>
</table>
<c:forEach var="i" begin="1" end="${totalPage }">
	<a href="listBoard?pageNum=${i }">${i }</a>&nbsp;&nbsp;
</c:forEach> <br>

</body>
</html>