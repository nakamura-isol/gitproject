package javadrill.exercise019.question034;



public class Customer {
	private String customerId;
	private String name;
	private String email;
	private int orderCount;

	Customer(String customerId, String name, String email, int orderCount) {
		this.customerId = customerId;
		this.name = name;
		this.email = email;
		this.orderCount = orderCount;
	}

	String getCustomerId() {
		return customerId;
	}

	void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	String getEmail() {
		return email;
	}

	void setEmail(String email) {
		this.email = email;
	}

	int getOrderCount() {
		return orderCount;
	}

	void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}

}
