<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 스크립틀릿, 표현식 --> jstl, el --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	td{
		border : 1px solid black;
		padding : 10px;
	}
</style>
</head>
<body>
	<h1>times tables - Jstl.jsp</h1>
	<table>
		<c:forEach begin="1" end="9" var="i">
			<tr>
				<c:forEach begin="2" end="9" var="j">
					<td>${j } * ${i } = ${j*i }</td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
</body>
</html>