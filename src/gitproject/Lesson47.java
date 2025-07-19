package gitproject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 抽選プログラム
 */
public class Lesson47 {

	public static void main(String[] args) {
		// 応募者を取得
		List<String> applicantList = readTxt("appList.txt");
		// 優先応募者を取得
		List<String> priorityList = readTxt("priorityList.txt");
		System.out.println("応募者は以下の通りです。");
		for (String applicant : applicantList) {
			System.out.println(applicant);
		}
		System.out.println("当選者数を入力してください。");
		Scanner sc = new Scanner(System.in);

		try {// 当選者数
			int numOfWinner = sc.nextInt();
			System.out.println("当選者は" + numOfWinner + "名は以下の通りです。");
			System.out.println("■当選者　■プライオリティ");
			// 当選者を取得
			List<String> winnerList = lottery(applicantList, priorityList, numOfWinner);
			for (String winner : winnerList) {
				if (priorityList.contains(winner)) {
					System.out.println(winner + " " + "○");
				} else {
					System.out.println(winner);
				}
			}

		} catch (Exception e) {
			System.out.println("数値を入力してください。");
		}

	}

	/**
	 * 引数のテキストファイルを読み込み、リストで返す
	 * @return
	 */
	private static List<String> readTxt(String txtName) {
		List<String> dataList = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(txtName))) {
			// 1行ずつストリームとして読み込み、リスト化
			dataList = br.lines().toList();
		} catch (FileNotFoundException e) {
			System.out.println("ファイルが見つかりませんでした。");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("読み込みエラーが発生しました。");
			e.printStackTrace();
		}
		return dataList;
	}

	/**
	 * 当選者を出す
	 * @return
	 */
	private static List<String> lottery(List<String> applicantList,
			List<String> priorityList, int numOfWinner) {
		// 抽選リストを作成（優先者は複数回追加して確率を上げる）
		List<String> weightedList = new ArrayList<>();
		// 当選者リスト
		List<String> winnerList = new ArrayList<>();
		// 一般応募者のID
		for (String applicant : applicantList) {
			// 優先者であった場合
			if (priorityList.contains(applicant)) {
				// 3回入れることで3倍の重みづけ
				for (int i = 0; i < 3; i++) {
					weightedList.add(applicant);
				}
			} else {
				weightedList.add(applicant);
			}
		}
		Collections.shuffle(weightedList);
		for (int i = 0; i < numOfWinner; i++) {
			String winner = weightedList.get(i);
			winnerList.add(winner);
		}
		return winnerList;
	}

}
