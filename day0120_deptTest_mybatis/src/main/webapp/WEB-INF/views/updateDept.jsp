<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>부서 수정</h2>
	<form action="updateDept.do" method="post">
		부서번호 : ${d.dno} <br>
		<input type="hidden" name="dno" value="${d.dno }">
		부서이름 : <input type="text" name="dname" value="${d.dname }"> <br>
		부서주소 : <input type="text" name="dloc" value="${d.dloc }"> <br>
		<input type="submit" value="수정"> 
	</form>
	
	<!-- 부서번호는 수정하는 것이 아니니 사용자가 아예 입력을 못하도록 하고싶음
	그렇다고 지워버리면 곤란함 
	수정시에 부서번호가 있어야 함
	사용자 화면에 보이지는 않지만 
	서버에게 값을 전달해 주기 위하여
	input type = 'hidden'을 사용함 -->
</body>
</html>