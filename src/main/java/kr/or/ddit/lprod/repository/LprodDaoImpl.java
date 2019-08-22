package kr.or.ddit.lprod.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.model.LprodVO;
import kr.or.ddit.util.MybatisUtil;

public class LprodDaoImpl implements ILprodDao{
	
	private static ILprodDao dao;
	
	private LprodDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public static ILprodDao getInstance() {
		if(dao == null) {
			dao = new LprodDaoImpl();
		}
		return dao;
	}
	
	@Override
	public List<LprodVO> getAll(SqlSession sqlSession) {
		return sqlSession.selectList("lprod.getAll");
	}

	@Override
	public List<LprodVO> getProd(SqlSession sqlSession, String lprod_gu) {
		return sqlSession.selectList("lprod.getProd", lprod_gu);
	}

	@Override
	public List<LprodVO> getLprodPagingList(SqlSession sqlSession, Page page) {
		return sqlSession.selectList("lprod.getLprodPagingList", page);
	}

	@Override
	public int getProdTotalCnt(SqlSession sqlSession) {
		return sqlSession.selectOne("lprod.getProdTotalCnt");
	}
}
