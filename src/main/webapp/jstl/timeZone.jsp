<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Before setTimeZone : <fmt:formatDate value="${dt}" pattern="yyyy-MM-dd HH:mm:ss"/> <br>
	<fmt:setTimeZone value="Asia/Bangkok"/>
	After setTimeZone : <fmt:formatDate value="${dt}" pattern="yyyy-MM-dd HH:mm:ss"/> <br>
	
	<table>
		<tr>
			<th>timeZone Id</th>
		</tr>
		<c:forEach items="${timeZoneList }" var="timeZone" >
			<tr>
				<td>${timeZone}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>