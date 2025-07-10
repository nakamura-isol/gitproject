package gitproject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
/**
 * ビンゴのガラガラを回す関数
 */
public class Lesson43 {

	public static void main(String[] args) {
		System.out.println("Enterを押す度に1~75までの数をランダムに返します。");
		Scanner scanner = new Scanner(System.in);
		// 1～75までのリストを準備
		List<Integer> numberList = new ArrayList<>();
		for (int i = 1; i <= 75; i++) {
			numberList.add(i);
		}
		// シャッフル
		Collections.shuffle(numberList);
		// 次に返すリストの位置（最初は0）
		int index = 0;
		while (true) {
			String enter = scanner.nextLine();
			if (!("end".equals(enter))) {
				if (index < numberList.size()) {
					System.out.println(numberList.get(index));
					index++;
				} else {
					System.out.println("0");
				}
			} else {
				System.out.println("終了します。");
				break;
			}

		}
	}
}