package kr.or.ddit.lprod.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.model.LprodVO;
import kr.or.ddit.lprod.repository.ILprodDao;
import kr.or.ddit.lprod.repository.LprodDaoImpl;
import kr.or.ddit.util.MybatisUtil;

public class LprodServiceImpl implements ILprodService {
	
	private ILprodDao dao;
	
	private LprodServiceImpl() {
		dao = LprodDaoImpl.getInstance();
	}
	
	private static ILprodService lprodService;
	
	public static ILprodService getInstance() {
		if(lprodService == null) {
			lprodService = new LprodServiceImpl();
		}
		return lprodService;
	}

	@Override
	public List<LprodVO> getAll() {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<LprodVO> list = dao.getAll(sqlSession);
		sqlSession.close();
		return list;
	}
	@Override
	public List<LprodVO> getProd(String lprod_gu) {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<LprodVO> list = dao.getProd(sqlSession, lprod_gu);
		sqlSession.close();
		return list;
	}
	@Override
	public Map<String, Object> getLprodPagingList(Page page) {
		Map<String, Object> map = new HashMap<String, Object>();
		SqlSession sqlSession = MybatisUtil.getSession();
		List<LprodVO> prodPagingList = dao.getLprodPagingList(sqlSession, page);
		int totalCnt = dao.getProdTotalCnt(sqlSession);
		sqlSession.close();
		
		map.put("prodPagingList", prodPagingList);
		map.put("paginationSize", (int) Math.ceil((double)totalCnt/page.getPageSize()));
		return map;
	}
	


}
