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

/**
 * Servlet implementation class ProdController
 */
@WebServlet("/prodList")
public class ProdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(ProdController.class);
	
	private ILprodDao lprodDao;
	
	@Override
	public void init() throws ServletException {
		lprodDao = new LprodDaoImpl();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lprod_gu = request.getParameter("lprod_gu");
		
		logger.debug("lprod_gu : {}", lprod_gu );
		
		List<LprodVO> prodList = lprodDao.getProd(lprod_gu);
		
		logger.debug("list.size() : {}", prodList.size());
		
		request.setAttribute("prodList", prodList);
		
		request.getRequestDispatcher("/prod/prodList.jsp").forward(request, response);
	}

}
