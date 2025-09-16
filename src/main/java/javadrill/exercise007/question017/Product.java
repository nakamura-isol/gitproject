package javadrill.exercise007.question017;

public class Product {
	private String item;
	private int price;
	private int stock;
	
	Product(String item,int price,int stock){
		this.item = item;
		this.price = price;
		this.stock = stock;
	}
	
	void displayProductInfo() {
		System.out.println(item);
		System.out.println(price);
		System.out.println(stock);
	}
	
	 String getItem() {
		return item;
	}

	 void setItem(String item) {
		this.item = item;
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
