package kr.or.ddit.user.repository;

import java.util.ArrayList;
import java.util.List;

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
		List<UserVO> userList = new ArrayList<UserVO>();
		userList.add(new UserVO("박진하"));
		userList.add(new UserVO("홍다은"));
		userList.add(new UserVO("강해신"));
		userList.add(new UserVO("윤경주"));
		return userList;
	}

}
