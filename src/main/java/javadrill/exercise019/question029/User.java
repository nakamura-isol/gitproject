package javadrill.exercise019.question029;

public class User {

	private String userId;
	private String userPassword;

	User(String userId, String userPassword) {
		this.userId = userId;
		this.userPassword = userPassword;
	}

	String getUserId() {
		return userId;
	}

	void setUserId(String userId) {
		this.userId = userId;
	}

	String getUserPassword() {
		return userPassword;
	}

	void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

}
