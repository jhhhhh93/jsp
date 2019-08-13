package kr.or.ddit.lprod.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.lprod.model.LprodVO;

public class LprodDaoImplTest {
	
	/**
	* Method : getAllTest
	* 작성자 : PC-21
	* 변경이력 :
	* Method 설명 : getAll() 메서드 테스트
	*/
	@Test
	public void getAllTest(){
		/***Given***/
		ILprodDao lprodDao = LprodDaoImpl.getInstance();
		
		/***When***/
		List<LprodVO> lprodList = lprodDao.getAll();
		
		/***Then***/
		assertEquals(12, lprodList.size());
	}
	
}
