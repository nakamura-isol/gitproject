package javadrill.exercise007.question017;

public class Main {

	public static void main(String[] args) {
		
		Shop shop = new Shop();

		
		Product chocolate = new Product("チョコ",200,3);
		Product caramel = new Product("キャラメル",300,10);

		shop.addProduct(chocolate);
		shop.addProduct(caramel);
		
		shop.displayProductList();

		shop.removeProduct(chocolate);
		shop.displayProductList();

	}

}
