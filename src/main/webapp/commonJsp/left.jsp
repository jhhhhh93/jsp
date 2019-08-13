<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul class="nav nav-sidebar">
		<li class="active"><a href="${pageContext.request.contextPath}/main.jsp">Main <span class="sr-only">(current)</span></a></li>
		<li class="active"><a href="${pageContext.request.contextPath}/userList">사용자리스트<span class="sr-only">(current)</span></a></li>
		<li class="active"><a href="${pageContext.request.contextPath}/userListOnlyHalf">사용자리스트(50)<span class="sr-only">(current)</span></a></li>
		<li class="active"><a href="${pageContext.request.contextPath}/lprodList">제품그룹리스트</a></li>
	</ul>
</body>
</html>