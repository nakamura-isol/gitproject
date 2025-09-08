package javadrill.exercise019.question034;

public class Product {
	private String productId;
	private String productName;
	private int price;
	private int stock;

	Product(String productId, String productName, int price, int stock) {
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.stock = stock;

	}

	String getProductId() {
		return productId;
	}

	void setProductId(String productId) {
		this.productId = productId;
	}

	String getProductName() {
		return productName;
	}

	void setProductName(String productName) {
		this.productName = productName;
	}

	int getPrice() {
		return price;
	}

	void setPrice(int price) {
		this.price = price;
	}

	int getStock() {
		return stock;
	}

	void setStock(int stock) {
		this.stock = stock;
	}

}
