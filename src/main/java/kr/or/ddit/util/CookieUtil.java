package kr.or.ddit.util;

public class CookieUtil {
	public static String getCookie(String cookieString, String cookieId) {
		String[] temp = cookieString.split(" ");
		
		String result = "";
		
		for(int i = 0; i < temp.length; i++) {
			if(cookieId.equals(temp[i].substring(0, temp[i].indexOf('=')))){
				result = temp[i].substring(temp[i].indexOf('=')+1, temp[i].indexOf(';'));
			}
		}
		return result;
	}
}
