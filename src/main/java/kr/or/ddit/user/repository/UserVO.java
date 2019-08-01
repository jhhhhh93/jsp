package kr.or.ddit.user.repository;

public class UserVO {
	private String userName;		// 사용자이름

	public UserVO(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "UserVO [userName=" + userName + "]";
	}
	
	
}
