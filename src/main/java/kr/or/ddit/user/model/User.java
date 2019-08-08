package kr.or.ddit.user.model;

public class User {
	private String userNM;		// 사용자이름
	private String userId;			// 사용자 아이디
	private String pass;			// 사용자 비밀번호
	
	public User() {
	}
	
	public User(String userNM) {
		this.userNM = userNM;
	}

	public String getUserName() {
		return userNM;
	}

	public void setUserName(String userNM) {
		this.userNM = userNM;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "UserVO [userName=" + userNM + ", userId=" + userId + ", pass=" + pass + "]";
	}
	
	public boolean checkLoginValidate(String userId, String pass) {
		if(userId.equals(this.userId) && pass.equals(this.pass)) {
			return true;
		}
		return false;
	}
	
}
