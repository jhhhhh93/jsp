<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath() %>/js/jquery-3.4.1.min.js"></script>
<script>
	// 문서 로딩이 완료된 다음에 실행
	$(function(){
		// 라디오 버튼 클릭이벤트 등록
		$("#get, #post").click(function(){
			// form태그의 method 방식을 클릭한 라디오 버튼의 value 값으로 변경 
			$('form').prop("method", $(this).prop("value"));
		})
	})
</script>
</head>
<body>
	<h2>get / post</h2>
	get : <input type="radio" id="get" name="method" va	lue="get" checked/>
	post : <input type="radio" id="post" name="method" value="post"/>
	<form action="<%=request.getContextPath() %>/SumServelet" method="post">
		번호 1 : <input type="text" name="number1"><br>
		번호 2 : <input type="text" name="number2"><br>
		<button>결과</button>
	</form>
	
</body>
</html>