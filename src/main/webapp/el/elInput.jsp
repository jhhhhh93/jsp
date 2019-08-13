<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/elScope" method="post">
		request : <input type="text" name="req" value="brown"/><br>
		session : <input type="text" name="session" value="cony"/><br>
		application : <input type="text" name="application" value="sally"/><br>
		<input type="submit" value="전송"/>
	</form>
	
	<h2>el scope test - jstl</h2>
 	<c:set var="attr" value="page_attr" scope="page"/>
	<c:set var="attr" value="request_attr" scope="request"/>
	<c:set var="attr" value="session_attr" scope="session"/>
	<c:set var="attr" value="application_attr" scope="application"/>
	
	el : ${attr } <br>
	<c:remove var="attr" scope="page"/>
 	el : ${attr } <br>
	<c:remove var="attr" scope="request"/>
	el : ${attr } <br>
	<c:remove var="attr" scope="session"/>
	el : ${attr } <br>
	<hr>
	
	
	<h2>el scope test</h2>
 	<% 
 		pageContext.setAttribute("attr", "page_attr");
 		request.setAttribute("attr", "request_attr");
		session.setAttribute("attr", "session_attr");
 		application.setAttribute("attr", "application_attr");
 	%> 
 	
 		pageScope : ${pageScope.attr}<br>
 		requestScope : ${requestScope.attr}<br>
 		sessionScope : ${sessionScope.attr}<br>
 		applicationScope : ${applicationScope.attr}<br>
 		<hr>
 	
 	el : ${attr}<br>

	<%
	   pageContext.removeAttribute("attr", pageContext.PAGE_SCOPE);
	%>
	el : ${attr}<br>
	
	<%
	   pageContext.removeAttribute("attr", pageContext.REQUEST_SCOPE);
	%>
	el : ${attr}<br>
	
	<%
	   pageContext.removeAttribute("attr", pageContext.SESSION_SCOPE);
	%>
	el : ${attr}<br>


</body>
</html>