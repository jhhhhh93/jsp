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
		int pageValue = Integer.parseInt(request.getParameter("page"));
		int pageSizeValue = Integer.parseInt(request.getParameter("pageSize"));
		
		Page page = new Page(pageValue, pageSizeValue);
		
		List<User> userList = (List<User>) userService.getUserPagingList(page).get("userList");
		int paginationSize = (int) userService.getUserPagingList(page).get("paginationSize");
		
		request.setAttribute("userList", userList);
		request.setAttribute("paginationSize", paginationSize);
		
		request.getRequestDispatcher("/user/userPagingList.jsp").forward(request, response);
	}

}
