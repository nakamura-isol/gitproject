package javadrill.exercise007.question017;

import java.util.ArrayList;
import java.util.List;

public class Shop {
	private List<Product> productList = new ArrayList<>();

	void addProduct(Product product) {
		productList.add(product);
	}

	void removeProduct(Product product) {
		productList.remove(product);
	}

	void displayProductList() {
		for (Product product : productList) {
			System.out.println(product.getItem() + "\t" + product.getPrice() + "\t" + product.getStock());
		}

	}
}
