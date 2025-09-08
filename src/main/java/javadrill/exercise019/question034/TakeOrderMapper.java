package javadrill.exercise019.question034;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TakeOrderMapper {

	Customer selectCustomerDataForCustomerId(@Param("customerId") String customerId);

	Product selectProductDataForProductId(@Param("productId") String productId);

	int updateProductStock(@Param("productId") String productId,
			@Param("newStock") int newStock);

	int updateCustomerOrderCount(@Param("customerId") String customerId,
			@Param("orderCount") int orderCount);

	// orderHistory.orderId に自動採番が入る
	int insertOrderHistoryData(OrderHistory orderHistory);

}
