<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String number1 = request.getParameter("number1");
		String number2 = request.getParameter("number2");
		int result = Integer.parseInt(request.getParameter("number1")) * Integer.parseInt(request.getParameter("number2"));  
	%>
	결과 : <%=number1 + " * " + number2 + " = " + result %> 
</body>
</html>