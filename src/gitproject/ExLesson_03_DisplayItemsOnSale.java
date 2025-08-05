package gitproject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * 購入日時から発売中の商品情報を表示する
 */
public class ExLesson_03_DisplayItemsOnSale {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String title;
		int price;
		// 発売日
		Date releaseDate = null;
		// 購入日
		Date purchaseDate = null;
		int count = 1;
		List<Item> itemList = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		while (true) {
			System.out.println(count + "つ目の商品情報を入力してください。" + "\n" + "商品名：");
			title = sc.nextLine();
			while (true) {
				System.out.println("価格：");
				try {
					price = Integer.parseInt(sc.nextLine());
					break;
				} catch (NumberFormatException e) {
					System.out.println("数値を入力してください。");
					continue;
				}
			}
			while (true) {
				System.out.println("発売日：");
				String stringReleaseDate = sc.nextLine();
				try {
					releaseDate = sdf.parse(stringReleaseDate);
					break;
				} catch (ParseException e) {
					System.out.println("発売日をyyyyMMdd形式に変換できませんでした。");
				}
			}
			Item item = new Item(title, price, releaseDate);
			itemList.add(item);
			count++;
			boolean inputedFinished = false;
			while (true) {
				System.out.println("続けて商品を入力しますか？");
				System.out.println("1：はい/2：いいえ");

				String isContinue = sc.nextLine();
				if (isContinue.equals("1")) {
					break;
				} else if (isContinue.equals("2")) {
					sc.close();
					inputedFinished = true;
					break;
				} else {
					System.out.println("1か2を入力してください。");
				}

			}
			if (inputedFinished) {
				break;
			}
		}
		try {
			// 起動引数の第一引数が未指定の場合は購入日は現在日付
			if (args.length < 1) {
				Date today = new Date();
				purchaseDate = today;
			} else {
				purchaseDate = sdf.parse(args[0]);
			}
		} catch (ParseException e) {
			System.out.println("起動引数の購入日を日付型に変換できませんでした。");
		}
		String argsTitle = null;
		if (args.length >= 2 && args[1] != null) {
			argsTitle = args[1];
		}
		List<Item> releasedItems = new ArrayList<>();
		for (Item item : itemList) {
			// 発売日が購入日以前かチェック
			boolean isReleasedItem = item.getReleaseDate().before(purchaseDate)
					|| item.getReleaseDate().equals(purchaseDate);
			// 起動引数に商品名があるなら部分一致してるものを
			// 起動引数に商品名がないなら発売済みのものを
			boolean isMatchedTitle = (argsTitle == null || item.getTitle().contains(argsTitle));
			if (isReleasedItem && isMatchedTitle) {
				releasedItems.add(item);
			}
		}
		// 商品表示処理
		if (releasedItems.isEmpty()) {
			System.out.println("商品が存在しません");
		} else {
			System.out.println("発売中の商品を表示します。");
			for (Item item : releasedItems) {
				System.out.println("商品名：" + item.getTitle());
				int priceWithTax = Calculation.getPriceIncludingTax(item.getPrice(), purchaseDate);
				System.out.println("価格：" + priceWithTax);
				System.out.println("発売日：" + sdf.format(item.getReleaseDate()));
			}
		}

	}

}
