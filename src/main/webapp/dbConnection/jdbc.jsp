<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
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
		long start = System.currentTimeMillis();

		for(int i = 0; i < 20; i++){
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:xe", 
						"PJH", 
						"java");
				String sql = "select * from lprod";
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				
				while(rs.next()){
					out.println("lprod_id : " + rs.getInt("lprod_id") + "<br>");
					out.println("lprod_gu : " + rs.getString(2) + "<br>");
					out.println("lprod_nm : " + rs.getString("lprod_nm") + "<br>");
					out.println("--------------------------------------------<br>");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				if(rs != null){
					try {rs.close();} catch (SQLException e2) {	}
				}
				if(stmt != null){
					try {stmt.close();} catch (SQLException e2) {	}
				}
				if(conn != null){
					try {conn.close();} catch (SQLException e2) {	}
				}
			}
		}
		//end
		long end = System.currentTimeMillis();
		
		out.print("end - start : " + (end - start) + "ms <br>");
		
%>
</body>
</html>