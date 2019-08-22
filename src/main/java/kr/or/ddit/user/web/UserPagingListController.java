package kr.or.ddit.user.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.user.model.User;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserServiceImpl;

/**
 * Servlet implementation class UserPagingList
 */
@WebServlet("/userPagingList")
public class UserPagingListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(UserPagingListController.class);
	
	private IUserService userService;
	
	@Override
	public void init() throws ServletException {
		userService = new UserServiceImpl();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// page, pageSize 파라미터 받기
		String pageValue = request.getParameter("page");
		String pageSizeValue = request.getParameter("pageSize");
		
		int page = pageValue == null ? 1 : Integer.parseInt(pageValue);
		int pageSize = pageSizeValue == null ? 10 : Integer.parseInt(pageSizeValue);
		
		Page p = new Page(page, pageSize);
		
		request.setAttribute("pageVo", p);
		
		List<User> userList = (List<User>) userService.getUserPagingList(p).get("userList");
		int paginationSize = (int) userService.getUserPagingList(p).get("paginationSize");
		
		request.setAttribute("userList", userList);
		request.setAttribute("paginationSize", paginationSize);
		
		request.getRequestDispatcher("/user/userPagingList.jsp").forward(request, response);
	}

}
