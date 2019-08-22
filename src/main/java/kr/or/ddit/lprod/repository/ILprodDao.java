package kr.or.ddit.lprod.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.model.LprodVO;

public interface ILprodDao {
	public List<LprodVO> getAll(SqlSession sqlSession);
	
	public List<LprodVO>getProd(SqlSession sqlSession, String lprod_gu);
	
	public List<LprodVO> getLprodPagingList(SqlSession sqlSession, Page page);
	
	public int getProdTotalCnt(SqlSession sqlSession);
}
