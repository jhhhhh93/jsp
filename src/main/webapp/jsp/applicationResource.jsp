<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// url의 리소스를 이용하여 디스크의 물리적 위치를 확인하는 메서드
	// /css/blog.css --> 물리적인 경로를 구해주는 메서드
	String blogCssPath = application.getRealPath("/css/blog.css");
	
	File file = new File(blogCssPath);
	FileInputStream fis = new FileInputStream(file);
	byte[] buffer = new byte[512];
	
	int len = 0;
	while((len=fis.read(buffer, 0, 512)) != -1){
	}
	
%>

	blogCssPath : <%=blogCssPath %><br>