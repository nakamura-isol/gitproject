package javadrill.exercise019.question034;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TakeOrderService {

	private final TakeOrderMapper takeOrderMapper;

	// 依存を注入
	public TakeOrderService(TakeOrderMapper takeOrderMapper) {
		this.takeOrderMapper = takeOrderMapper;
	}

	public Customer getCustomerDataByCustomerId(String customerId) {
		return takeOrderMapper.selectCustomerDataForCustomerId(customerId);
	}

	public Product getProductDataByProductId(String productId) {
		return takeOrderMapper.selectProductDataForProductId(productId);
	}

	/**
	 * 注文受付メソッド
	 * @param customerId
	 * @param productId
	 * @param quantity
	 */
	@Transactional
	public void takeOrder(String customerId, String productId, int quantity)  {

		// 顧客情報取得
		Customer customer = getCustomerDataByCustomerId(customerId);

		// 商品情報取得
		Product product = getProductDataByProductId(productId);

		// 顧客チェック
		checkCustomer(customer);

		// 商品チェック
		checkProduct(product, quantity);

		// 商品テーブル更新
		updateProduct(product, quantity);

		// 顧客テーブル更新
		updateCustomer(customer);

		// 注文履歴テーブル更新
		updateOrderHistory(customer, product,
				quantity);

		System.out.println("商品の注文が完了しました。");

	}

	/**
	 * 顧客確認メソッド
	 * @param connection 
	 * @param customer
	 */
	private void checkCustomer(Customer customer) {
		if (customer == null) {
			throw new IllegalStateException("顧客ではありません。");
		}

	}

	/**
	 * 商品チェックメソッド
	 * 該当商品があるか、在庫があるか
	 */
	private void checkProduct(Product product, int quantity) {
		if (product == null) {
			throw new IllegalStateException("該当の商品は扱っておりません。");
		}
		if (product.getStock() < quantity) {
			throw new IllegalStateException("在庫がありません。");
		}
	}

	/**
	 * 商品テーブル更新メソッド
	 * @param connection
	 * @param product
	 * @param quantity
	 */

	private void updateProduct(Product product, int quantity) {
		int newStock = product.getStock() - quantity;
		int affectedRows = takeOrderMapper.updateProductStock(product.getProductId(), newStock);
		if (affectedRows == 0) {
			throw new IllegalStateException("更新に失敗しました。");
		}
	}

	/**
	 * 顧客テーブル更新メソッド
	 * @param connection
	 * @param customer
	 */
	private void updateCustomer(Customer customer) {
		int newOrderCount = customer.getOrderCount();
		newOrderCount++;
		int affectedRows = takeOrderMapper.updateCustomerOrderCount(customer.getCustomerId(), newOrderCount);
		if (affectedRows == 0) {
			throw new IllegalStateException("更新に失敗しました。");
		}
	}

	/**
	 * 注文履歴テーブル更新メソッド
	 * @param connection
	 * @param customer
	 * @param product
	 * @param quantity
	 */
	private void updateOrderHistory(Customer customer, Product product, int quantity) {
		int totalAmount = product.getPrice() * quantity;
		OrderHistory orderHistory = new OrderHistory(customer.getCustomerId(), product.getProductId(),
				product.getProductName(), totalAmount);
		int affectedRows = takeOrderMapper.insertOrderHistoryData(orderHistory);
		if (affectedRows == 0) {
			throw new IllegalStateException("更新に失敗しました。");
		}
	}

}
