package kr.or.ddit.lprod.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.lprod.model.LprodVO;
import kr.or.ddit.lprod.repository.ILprodDao;
import kr.or.ddit.lprod.repository.LprodDaoImpl;
import kr.or.ddit.lprod.service.ILprodService;
import kr.or.ddit.lprod.service.LprodServiceImpl;

/**
 * Servlet implementation class LprodList
 */
@WebServlet("/lprodList")
public class LprodListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ILprodService lprodService;
	
	@Override
	public void init() throws ServletException {
		lprodService = LprodServiceImpl.getInstance();
	}
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<LprodVO> lprodList = lprodService.getAll();
		
		request.setAttribute("lprodList", lprodList);
		request.getRequestDispatcher("/lprod/lprodList.jsp").forward(request, response);
	}


}
