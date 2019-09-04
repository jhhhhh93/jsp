package kr.or.ddit.user.service;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.user.model.User;

public class UserServiceImplTest {
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImplTest.class);
	
	private IUserService userService;
	private String userId = "brownTest";
	
	@Before
	public void setup() {
		logger.debug("UserServiceTest Before()");
		userService = new UserServiceImpl();
		
		int deleteCnt = userService.deleteUser(userId);
	}
	
	/**
	* 
   * Method : getUserListTest
   * 작성자 : PC-08
   * 변경이력 :
   * Method 설명 : getUserList 테스트
    */
   @Test
   public void getUserListTest() {
      /***Given***/
      
      /***When***/
      List<User> userList = userService.getUserList();
      
      /***Then***/
      assertEquals(105, userList.size());
   }
   
   /**
    * 
   * Method : getUserTest
   * 작성자 : PC-08
   * 변경이력 :
   * Method 설명 : 사용자 정보 조회 테스트
    */
   @Test
   public void getUserTest() {
      /***Given***/
      String userId = "brown";

      /***When***/
      User userVo = userService.getUser(userId);
      
      /***Then***/
      assertEquals("브라운", userVo.getUserName());
      assertEquals("brown1234", userVo.getPass());
   }
   
   /**
    * 
   * Method : getUserListHalf
   * 작성자 : PC-08
   * 변경이력 :
   * Method 설명 : getUserListHalf 테스트
    */
   @Test
   public void getUserListOnlyHalfTest() {
      /***Given***/
      
      /***When***/
      List<User> userListHalf = userService.getUserListOnlyHalf();
      
      /***Then***/
      assertEquals(50, userListHalf.size());
   }
   
   /**
	* Method : getUserPagingListTest
	* 작성자 : PC-21
	* 변경이력 :
	* Method 설명 : 사용자 페이징 리스트 조회 테스트
	*/
	@Test
	public void getUserPagingListTest() {
		/*** Given ***/
		Page page = new Page();
		page.setPage(3);
		page.setPageSize(10);

		/*** When ***/
		List<User> userList = (List<User>) userService.getUserPagingList(page).get("userList");
		int paginationSize = (int) userService.getUserPagingList(page).get("paginationSize");
		
		/*** Then ***/
		assertEquals(10, userList.size());
		assertEquals("xuserid22", userList.get(0).getUserId());
		assertEquals(11, paginationSize);
		
	}
	
	@Test
	public void ceilingTest() {
		/***Given***/
		int totalCnt = 105;
		int pageSize = 10;
		
		/***When***/
		int paginationSize = (int) Math.ceil((double)totalCnt/pageSize);

		/***Then***/
		assertEquals(11, paginationSize);
	}
	
	@Test
	public void insertUserTest() throws ParseException {
		/***Given***/
		User user = new User();
		
		user.setUserId(userId);
		user.setUserName("브라운테스트");
		user.setPass("brownTest1234");
		user.setReg_dt(new SimpleDateFormat("yyyy-MM-dd").parse("2019-08-08"));
		user.setAlias("곰테스트");
		user.setAddr1("대전광역시 중구 중앙로 76");
		user.setAddr2("영민빌딩 2층 DDIT");
		user.setZipcode("34940");
		user.setFilename("sally");
		user.setRealfilename("testfilename");
		
		/***When***/
		int insertCnt = userService.insertUser(user);
		
		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	@Test
	public void updateUser() throws ParseException {
		/***Given***/
		User user = new User();
		
		user.setUserId(userId);
		user.setUserName("정보수정");
		user.setPass("brownTest1234");
		user.setReg_dt(new SimpleDateFormat("yyyy-MM-dd").parse("2019-08-08"));
		user.setAlias("곰테스트");
		user.setAddr1("대전광역시 중구 중앙로 76");
		user.setAddr2("영민빌딩 2층 DDIT");
		user.setZipcode("34940");
		user.setFilename("sally");
		user.setRealfilename("testfilename");
		
		/***When***/
		int insertCnt = userService.insertUser(user);
		int updateCnt = userService.updateUser(user);

		/***Then***/
		assertEquals(1, insertCnt);
		assertEquals(1, updateCnt);
	}
   
}
