package kr.or.ddit.lprod.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.model.LprodVO;
import kr.or.ddit.lprod.service.ILprodService;
import kr.or.ddit.lprod.service.LprodServiceImpl;

/**
 * Servlet implementation class LprodPagingListController
 */
@WebServlet("/lprodPagingList")
public class LprodPagingListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ILprodService lprodService;
	
	@Override
	public void init() throws ServletException {
		lprodService = LprodServiceImpl.getInstance();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageValue = request.getParameter("page");
		String pageSizeValue = request.getParameter("pageSize");
		
		int page = pageValue == null ? 1 : Integer.parseInt(pageValue);
		int pageSize = pageSizeValue == null ? 5 : Integer.parseInt(pageSizeValue);
		
		Page p = new Page(page, pageSize);
		
		request.setAttribute("pageVo", p);
		
		Map<String, Object> map = lprodService.getLprodPagingList(p);
		List<LprodVO> lprodList = (List<LprodVO>) map.get("prodPagingList");
		int paginationSize = (int) map.get("paginationSize");
		
		request.setAttribute("lprodList", lprodList);
		request.setAttribute("paginationSize", paginationSize);
		
		request.getRequestDispatcher("/lprod/lprodPagingList.jsp").forward(request, response);
		
	}


}
