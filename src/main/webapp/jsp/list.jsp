<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.or.ddit.user.repository.UserVO"%>
<%@page import="kr.or.ddit.user.repository.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	UserDao dao = new UserDao(); 
	List<UserVO> list = new ArrayList<UserVO>();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	th, td{
		border : 1px solid black;
		padding : 10px;
	}
</style>
</head>
<body>
	<%-- 1. userdao 선언 --%>
	<%-- 2. getUserList() 호출 --%>
	<%-- 3. 호출 결과(List<UserVO>)를 for loop를 통해 tr태그를 반복생성 --%>
	<table border = 1>
		<tr>
			<th>이름</th>
		</tr>
		<%for(UserVO userVo : list){ %>
			<tr>
				<td><%=userVo.getUserName()%></td>
			</tr>
		<%} %>
		<%list = dao.getUserList();%>
		<%for(int i = 0; i < list.size(); i++){ %>
			<tr>
				<td><%=list.get(i).getUserName() %></td>
			</tr>
		<%} %>
	</table>
</body>
</html>