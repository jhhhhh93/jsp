package kr.or.ddit.mvc.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import ch.qos.logback.core.db.dialect.MySQLDialect;
import kr.or.ddit.mvc.model.UrlMapping;
import kr.or.ddit.util.MybatisUtil;

public class UrlMappingDaoImpl implements IUrlMappingDao {

	@Override
	public List<UrlMapping> getUrlMapping() {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<UrlMapping> urlMapping = sqlSession.selectList("db.getUrlMapping");
		sqlSession.close();
		return urlMapping;
		
	}

}
