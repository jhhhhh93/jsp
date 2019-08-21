package kr.or.ddit.user.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.user.model.User;

public class UserServiceImplTest {
	
	private IUserService userService;
	
	@Before
	public void setup() {
		userService = new UserServiceImpl();
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
   
}
