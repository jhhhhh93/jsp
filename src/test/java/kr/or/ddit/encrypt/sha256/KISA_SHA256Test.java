package kr.or.ddit.encrypt.sha256;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.encrypt.kisa.sha256.KISA_SHA256;

public class KISA_SHA256Test {
	private static final Logger logger = LoggerFactory.getLogger(KISA_SHA256Test.class);
	
	/**
	* Method : encryptTest
	* 작성자 : PC-21
	* 변경이력 :
	* Method 설명 : sha256 암호화 테스트
	*/
	@Test
	public void encryptTest() {
		/***Given***/
		String pass = "brown1234";
		
		/***When***/
		String encryptedPass = KISA_SHA256.encrypt(pass);
		logger.debug("encryptedPass : {}", encryptedPass);
		
		/***Then***/
		
	}

}
