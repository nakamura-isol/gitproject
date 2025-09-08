package javadrill.exercise019.question034;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

/**
 * 
 */
@Component
@RequiredArgsConstructor
public class TakeOrderRunner implements CommandLineRunner {

	// コンストラクタDI
	private final TakeOrderService takeOrderService;

	@Override
	public void run(String... args) {

		try {
			// ユーザが商品を注文する
			takeOrderService.takeOrder("7", "10001", 1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}

	}

}
