package kr.or.ddit.lprod.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.lprod.model.LprodVO;
import kr.or.ddit.lprod.repository.ILprodDao;
import kr.or.ddit.lprod.repository.LprodDaoImpl;
import kr.or.ddit.lprod.service.ILprodService;
import kr.or.ddit.lprod.service.LprodServiceImpl;

/**
 * Servlet implementation class ProdController
 */
@WebServlet("/prodList")
public class ProdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(ProdController.class);
	
	private ILprodService lprodService;
	
	@Override
	public void init() throws ServletException {
		lprodService = LprodServiceImpl.getInstance();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lprod_gu = request.getParameter("lprod_gu");
		
		logger.debug("lprod_gu : {}", lprod_gu );
		
		List<LprodVO> prodList = lprodService.getProd(lprod_gu);
		
		logger.debug("list.size() : {}", prodList.size());
		
		request.setAttribute("prodList", prodList);
		
		request.getRequestDispatcher("/prod/prodList.jsp").forward(request, response);
	}

}
