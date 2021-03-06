<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="listGoods" method="post">
	<select name="searchColumn">
		<option value="name">상품이름</option>
	</select>
	<input type="text" name="keyword">
	<input type="submit" value="검색">
</form>

<a href="insertGoods">상품등록</a>
	<h2>상품목록</h2>
	<hr>
	<table border="1" width="80%">
		<tr>
			<td>상품이름</td>
			<td>상품번호</td>
		</tr>
		<c:forEach var="g" items="${list }" >
			<tr>
				<td>${g.no }</td>
				<td><a href="detailGoods?no=${g.no}">${g.name }</a></td>
			</tr>
		</c:forEach>
	</table>
	<hr>
	<c:forEach var="i" begin="1" end="${totalPage }">
	<a href="listGoods?pageNum=${i }">${i }</a> &nbsp;&nbsp;
	</c:forEach>
</body>
</html>