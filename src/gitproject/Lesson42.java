import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * 5%の確率でやかんを出してくるドラえもんのプログラム
 */
public class Lesson42_2 {

	public static void main(String[] args) {
		System.out.println("Enterを押す度、5%の確率でやかんが出てきます。");
		String filePath = "C:\\Users\\highe\\OneDrive\\ドキュメント\\自己学習\\Lesson42.txt";
		List<String> itemList = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String item;
			// ファイルから全アイテム取得
			while ((item = br.readLine()) != null) {
				itemList.add(item);
			}
		} catch (IOException e) {
			System.out.println("ファイルがありませんでした。");
			e.printStackTrace();
		}
		Scanner scanner = new Scanner(System.in);
		while (true) {
			String enter = scanner.nextLine();
			if ("end".equals(enter)) {
				break;
			}
			String getResult = getItem(itemList);
			System.out.println(getResult);
		}
		System.out.println("終了します。");
	}

	/**
	 * trueならやかん、falseならやかん以外を返す
	 */
	private static String getItem(List<String> itemList) {
		Random random = new Random();
		// 1から100の乱数生成（5%の確率でやかん）
		int yakan = random.nextInt(100) + 1;
		if (yakan <= 5) {
			return itemList.get(0);
		} else {
			// やかん以外のアイテムからランダムで選択（1行目以降）
			int index = random.nextInt(itemList.size() - 1) + 1;
			return itemList.get(index);

		}
	}

}
