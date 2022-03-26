<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src=" https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#btnRead").click(function(){
			$.ajax({
				url:"listDept.do,
				success:function(arr){
					let arr = eval("("+data+")");
					$.each(arr,function(index,item){
						let tr = $("<tr></tr>");
						$(tr).append($("<td></td>").html(item.dno));
						$(tr).append($("<td></td>").html(item.dname));
						$(tr).append($("<td></td>").html(item.dloc));
						$("tbody").append(tr);
					});
				}
			})
		});
	});
</script>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<td>부서번호</td>
				<td>부서명</td>
				<td>부서위치</td>
			</tr>
		</thead>
		<tbody></tbody>
	</table>
	
	<hr>
	<button id="btnRead">부서목록 읽어오기</button>
	
</body>
</html>