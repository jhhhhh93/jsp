package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimesTablesServlet extends HttpServlet {
	
	private Logger logger = LoggerFactory.getLogger(TimesTablesServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// System.out.println("TimesTablesServlet deGet()");
		
		String method = req.getMethod();
		
		logger.trace("trace TimesTablesServlet doGet()");
		logger.debug("debug TimesTablesServlet doGet() {}", method);
		logger.info("info TimesTablesServlet doGet()");
		logger.warn("warn TimesTablesServlet doGet()");
		logger.error("error TimesTablesServlet doGet()");
		
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter pw = resp.getWriter();
		
		
		pw.println("<html>");
		pw.println("	<head>");
		pw.println("		<style>");
		pw.println("			td{");
		pw.println("				border : 1px solid black;");
		pw.println("				padding : 10px;");
		pw.println("			}");
		pw.println("		</style>");
		pw.println("	</head>");
		pw.println("	<body>");
		pw.println("		<table border='0'>");
		for(int i = 1; i < 10; i++) {
			pw.println("			<tr>");
			for(int j = 2; j < 10; j++) {
				pw.println("				<td>" + j + " * " + i + " = " + j*i + "</td>");
			}
			pw.println("			</tr>");
		}
		pw.println("		</table>");
		pw.println("	</body>");
		pw.println("</html>");
	}
}
