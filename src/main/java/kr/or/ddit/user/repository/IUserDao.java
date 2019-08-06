package kr.or.ddit.user.repository;

import java.util.List;

import kr.or.ddit.user.model.UserVO;

public interface IUserDao {
	List<UserVO> getUserList();
	
	UserVO getUser(String userId);
}
