package javadrill.exercise019.question034;

public class OrderHistory {
	private String orderId;
	private String customerId;
	private String productId;
	private String productName;
	private int totalAmount;

	OrderHistory() {

	}

	OrderHistory(String customerId, String productId, String productName, int totalAmount) {
		this.customerId = customerId;
		this.productId = productId;
		this.productName = productName;
		this.totalAmount = totalAmount;
	}

	String getOrderId() {
		return orderId;
	}

	void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	String getCustomerId() {
		return customerId;
	}

	void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	String getProductName() {
		return productName;
	}

	void setProductName(String productName) {
		this.productName = productName;
	}

	int getAmount() {
		return totalAmount;
	}

	void setAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	String getProductId() {
		return productId;
	}

	void setProductId(String productId) {
		this.productId = productId;
	}

}
