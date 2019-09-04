<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-3.4.1.min.js"></script>
<script>
	$(function(){
		$("#locale").on("change", function(){
			$("#frm").submit();
		})
	})
</script>
</head>
<body>
	<form id="frm" action="${cp}/selectLocale" method="get">
		<select id="locale" name="locale">
			<c:choose>
				<c:when test="${locale == 'zh'}">
					<option value="ko">한국어</option>
					<option value="en">English</option>
					<option value="zh" selected>中國语</option>
				</c:when>
				<c:when test="${locale == 'en'}">
					<option value="ko">한국어</option>
					<option value="en" selected>English</option>
					<option value="zh">中國语</option>
				</c:when>
				<c:otherwise>
					<option value="ko" selected>한국어</option>
					<option value="en">English</option>
					<option value="zh">中國语</option>
				</c:otherwise>
			</c:choose>
		</select>
	</form>
	
	<fmt:setLocale value="${locale}"/>
	<fmt:setBundle basename="kr.or.ddit.msg.message" var="msg"/>
	<fmt:message key="GREETING" bundle="${msg}"/><br>
</body>
</html>