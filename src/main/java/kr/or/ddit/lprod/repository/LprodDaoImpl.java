package kr.or.ddit.lprod.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.lprod.model.LprodVO;
import kr.or.ddit.util.MybatisUtil;

public class LprodDaoImpl implements ILprodDao{
	
	private static ILprodDao dao;
	
	public static ILprodDao getInstance() {
		if(dao == null) {
			dao = new LprodDaoImpl();
		}
		return dao;
	}
	
	@Override
	public List<LprodVO> getAll() {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<LprodVO> list = sqlSession.selectList("lprod.getAll");
		sqlSession.close();
		return list;
	}

	@Override
	public List<LprodVO> getProd(String lprod_gu) {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<LprodVO> list = sqlSession.selectList("lprod.getProd", lprod_gu);
		sqlSession.close();
		return list;
	}
	
}
