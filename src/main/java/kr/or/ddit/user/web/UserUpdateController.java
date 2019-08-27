package kr.or.ddit.user.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.User;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserServiceImpl;
import kr.or.ddit.util.FileuploadUtil;

/**
 * Servlet implementation class UserUpdateController
 */
@WebServlet("/userUpdate")
@MultipartConfig(maxFileSize = 1024*1024*5, maxRequestSize = 1024*1024*5*5)
public class UserUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(UserUpdateController.class);
	
	private IUserService userService;
	
	@Override
	public void init() throws ServletException {
		userService = new UserServiceImpl();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		
		logger.debug("userId : {}", userId);
		
		User user = userService.getUser(userId);
		
		logger.debug("userfilename : {}", user.getFilename());
		logger.debug("userrealfilename : {}", user.getRealfilename());
		
		request.setAttribute("user", user);
		
		request.getRequestDispatcher("/user/userUpdate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		String userNm = request.getParameter("userNm");
		String userAlias = request.getParameter("userAlias");
		String reg_dt = request.getParameter("reg_dt");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String zipcode = request.getParameter("zipcode");
		String pass = request.getParameter("pass");
		Date reg_dt_date = null;
		
		logger.debug("userId : {}, userNM : {}, Alias : {}, reg_dt : {}, addr1 : {}, addr2 : {}, zipcode : {}, pass : {}",
				userId, userNm, userAlias, reg_dt, addr1, addr2, zipcode, pass );
		Part picture = request.getPart("picture");
		
		// 사용자가 파일을 업로드 한 경우
		String filename = "";
		String path = "";
		if(picture.getSize() > 0) {
			filename = FileuploadUtil.getFilename(picture.getHeader("Content-Disposition"));	// 사용자가 업로드한 파일명
			String realfilename = UUID.randomUUID().toString();
			String ext = FileuploadUtil.getFileExtension(picture.getHeader("Content-Disposition"));
			path = FileuploadUtil.getPath() + realfilename + ext;
			picture.write(path);
		}
		// 업로드 하지 않은 경우
		else {
			filename = request.getParameter("filename");
			path = request.getParameter("realfilename");
		}
		
		try {
			reg_dt_date = new SimpleDateFormat("yyyy-MM-dd").parse(reg_dt);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		User user = new User(userNm, userId, pass, reg_dt_date, userAlias, addr1, addr2, zipcode, filename, path);
		int updateCnt = 0; 
		
		try {
			updateCnt = userService.updateUser(user);
			
			if(updateCnt == 1) {
				response.sendRedirect(request.getContextPath() + "/user?userId=" + userId);
			}
		} catch (Exception e) {
			doGet(request, response);
		}
	}

}
