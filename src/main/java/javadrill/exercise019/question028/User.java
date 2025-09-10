package javadrill.exercise019.question028;

public class User {
	private String userId;
	private String userPassword;
	private String userName;
	private String email;

	User(String userId, String userPassword, String userName, String email) {
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.email = email;

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

	String getUserName() {
		return userName;
	}

	void setUserName(String userName) {
		this.userName = userName;
	}

	String getEmail() {
		return email;
	}

	void setEmail(String email) {
		this.email = email;
	}

}
