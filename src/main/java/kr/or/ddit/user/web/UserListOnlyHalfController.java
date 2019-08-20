package kr.or.ddit.user.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.User;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserServiceImpl;

/**
 * Servlet implementation class UserListOnlyHalfController
 */
@WebServlet("/userListOnlyHalf")
public class UserListOnlyHalfController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IUserService userService;
	
	@Override
		public void init() throws ServletException {
			userService = new UserServiceImpl();
		}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<User> userListOnlyHalf = userService.getUserListOnlyHalf();
		
		request.setAttribute("userListOnlyHalf", userListOnlyHalf);
		
		request.getRequestDispatcher("/user/userListOnlyHalf.jsp").forward(request, response);
	}


}
