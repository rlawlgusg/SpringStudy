<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>부서상세</h2>
	<hr>
	부서번호 : ${d.dno } <br>
	부서이름 : ${d.dname } <br>
	부서지역 : ${d.dloc } <br>
	<a href="updateDept.do?dno=${d.dno}">부서수정</a>
	<a href="deleteDept.do?dno=${d.dno}">부서삭제</a>
</body>
</html>