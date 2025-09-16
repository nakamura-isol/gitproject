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
			// TODO 在庫が丁度切れる、成功パターン、複数ケース試す
			// TODO 途中で落ちた場合のロールバックがされているか
			takeOrderService.takeOrder("1", "10001", 87);
//			takeOrderService.takeOrder("1", "10004", 1);
//			takeOrderService.takeOrder("1", "10004", 1);
//			takeOrderService.takeOrder("1", "10004", 1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
	}
}
