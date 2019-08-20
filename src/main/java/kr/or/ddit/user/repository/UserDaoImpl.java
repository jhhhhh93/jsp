package kr.or.ddit.user.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.user.model.User;
import kr.or.ddit.util.MybatisUtil;

public class UserDaoImpl implements IUserDao{

	/**
	* Method : getUserList
	* 작성자 : PC-21
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 리스트 조회
	*/
	@Override
	public List<User> getUserList(SqlSession sqlSession) {
		return sqlSession.selectList("user.getUserList");
	}

	@Override
	public User getUser(SqlSession sqlSession, String userId) {
		return sqlSession.selectOne("user.getUser", userId);
	}

	@Override
	public List<User> getUserListOnlyHalf(SqlSession sqlSession) {
		return sqlSession.selectList("user.getUserListOnlyHalf");
	}

}
