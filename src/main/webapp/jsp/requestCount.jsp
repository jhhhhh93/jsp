<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>uri 통계자료</h2>
	<table>
		<tr>
			<th>uri</th>
			<th>method</th>
			<th>횟수</th>
		</tr>
		<c:forEach items="${requestCountMap}" var="map">
			<tr>
				<td>${fn:substringBefore(map.key, '&')}</td>
				<td>${fn:substringAfter(map.key, '&')}</td>
				<td>${map.value}</td>
			</tr>		
		</c:forEach>
	</table>
</body>
</html>