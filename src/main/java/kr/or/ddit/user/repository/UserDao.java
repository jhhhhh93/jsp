package kr.or.ddit.user.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.util.MybatisUtil;

public class UserDao implements IUserDao{

	/**
	* Method : getUserList
	* 작성자 : PC-21
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 리스트 조회
	*/
	@Override
	public List<UserVO> getUserList() {
		// db에서 조회가 되었다고 가정하고 가짜 객체를 리턴
//		List<UserVO> userList = new ArrayList<UserVO>();
//		userList.add(new UserVO("박진하"));
//		userList.add(new UserVO("홍다은"));
//		userList.add(new UserVO("강해신"));
//		userList.add(new UserVO("윤경주"));
		SqlSession sqlSession = MybatisUtil.getSession();
		List<UserVO> userList = sqlSession.selectList("user.getUserList");
		sqlSession.close(); // *****중요

		return userList;
	}

	@Override
	public UserVO getUser(String userId) {
		SqlSession sqlSession = MybatisUtil.getSession();
		UserVO userVo = sqlSession.selectOne("user.getUser", userId);
		sqlSession.close();
		
		return userVo;
	}

}
