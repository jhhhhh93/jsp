<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/sumCalculation" method="post">
		start : <input type="text" name="start"><br>
		end : <input type="text" name="end"><br>
		<button>submit</button>
	</form>
</body>
</html>