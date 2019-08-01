<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>get login</h2>
	<!-- 
		서버로 요청을 보낼 때
		1. form 태그 작성
			- action : 요청을 보낼 주소
			- method (get/post)
		2. input, select, checkbox, radio, textarea
			- 파라미터로 보내기 위해서는 위 태그의 속성중에 name 속성이 반드시 존재해야한다.
			- name 속성의 값이 파라미터 이름
			- value 속성이 파라미터 값
	 -->
	<form action="/jsp/getLoginProcess.jsp" method="get">
		ID : <input type="text" name="userId" value="id1"/><br>
		ID : <input type="text" name="userId" value="id2"/><br>
		PW : <input type="password" name="password" value="pw1"><br>
		<input type="submit" value="로그인"/>
	</form>
	<h2>post login</h2>
	<form action="/jsp/getLoginProcess.jsp" method="post">
		ID : <input type="text" name="userId" value="id1"/><br>
		ID : <input type="text" name="userId" value="id2"/><br>
		PW : <input type="password" name="password" value="pw1"><br>
		<input type="submit" value="로그인"/>
	</form>
</body>
</html>