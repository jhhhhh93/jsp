package kr.or.ddit.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CookieUtilTest {
	
	@Test
	public void getCookieTest() {
		/***Given***/
		String cookieString = "rememberMe=Y; test=testValue; userId=brown;";
		
		/***When***/
		String userIdCookieValue = CookieUtil.getCookie(cookieString, "userId");
		String remeberMeCookieValue = CookieUtil.getCookie(cookieString, "rememberMe");
		String testCookieValue = CookieUtil.getCookie(cookieString, "test");
		
		
		/***Then***/
		assertEquals("brown", userIdCookieValue);
		assertEquals("Y", remeberMeCookieValue);
		assertEquals("testValue", testCookieValue);
	}
}
