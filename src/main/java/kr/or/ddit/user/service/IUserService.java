package kr.or.ddit.user.service;

import java.util.List;

import kr.or.ddit.user.model.User;

public interface IUserService {
	/**
	* Method : getUserList
	* 작성자 : PC-21
	* 변경이력 :
	* @return
	* Method 설명 : 전체 사용자 리스트 조회
	*/
	List<User> getUserList();
	
	/**
	* Method : getUser
	* 작성자 : PC-21
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 사용자 상세조회
	*/
	User getUser(String userId);
	
	/**
	* Method : getUserListOnlyHalf
	* 작성자 : PC-21
	* 변경이력 :
	* @return
	* Method 설명 : 전체 사용자 조회 (50명제한)
	*/
	public List<User> getUserListOnlyHalf();
}
