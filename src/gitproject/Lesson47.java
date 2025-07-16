package gitproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 抽選プログラム（3人選出）
 */
public class Lesson47 {

	public static void main(String[] args) {
		// 応募者を取得
		List<String> applicantList = readAppList();
		// 過去の当選者を取得
		List<String> pastWinnerList = readWinnerList();
		// 優先応募者を取得
		List<String> priorityList = readPriorityList();
		if (applicantList.size() == pastWinnerList.size()) {
			System.out.println("全員が過去に当選済みです。抽選対象がいません。");
			//途中で抜ける（処理中断）
			return;
		}
		// 当選番号を取得
		List<Integer> hitNums = getHitNum(applicantList, pastWinnerList, priorityList);
		if (hitNums == null) {
			System.out.println("抽選対象者が３人未満です。");
		} else {
			// 応募者のインデックスと当選番号を比較する
			// Listの値を取得する際、インデックスは0から始まるので-1にする
			for (int hitNum : hitNums) {
				String winner = applicantList.get(hitNum - 1);
				System.out.println(winner);
				// 当選者を保存追記
				writeToWinnerList(winner);
			}
		}
	}

	/**
	 * appList.txtを読み込んで全応募者のIDを返す
	 *
	 */
	private static List<String> readAppList() {
		String appListPath = "appList47.txt";
		List<String> applicantIdList = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(appListPath))) {
			String idLine;
			while ((idLine = br.readLine()) != null) {
				// 応募者IDを全て読み込む
				applicantIdList.add(idLine);
			}
		} catch (FileNotFoundException e) {
			System.out.println("ファイルが見つかりませんでした。");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("読み込みエラーが発生しました。");
			e.printStackTrace();
		}
		return applicantIdList;
	}

	/**
	 * winnerList.txtを読み込んで過去の当選者のIDを返す
	 */
	private static List<String> readWinnerList() {
		// ファイル読み込む
		String winnerListPath = "winnerList47.txt";
		List<String> pastWinnerIdList = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(winnerListPath))) {
			String pastWinnerLine;
			while ((pastWinnerLine = br.readLine()) != null) {
				pastWinnerIdList.add(pastWinnerLine);
			}
		} catch (FileNotFoundException e) {
			System.out.println("ファイルが見つかりませんでした。");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("読み込みエラーが発生しました。");
			e.printStackTrace();
		}
		return pastWinnerIdList;
	}

	/**
	 * 当選番号を出す
	 * @return
	 */
	private static List<Integer> getHitNum(List<String> applicantList, List<String> pastWinnerList,
			List<String> priorityList) {
		Random random = new Random();
		// 当選番号のインデックスリスト
		List<Integer> selectedIndexList = new ArrayList<>();
		// 優先応募者のインデックスリスト
		List<Integer> priorityIndexList = new ArrayList<>();
		// 一般応募者のインデックスリスト
		List<Integer> normalIndexList = new ArrayList<>();

		// 応募者リストから過去の当選者以外を取得し、当選対象者のインデックスリストに格納する
		for (int i = 0; i < applicantList.size(); i++) {
			String applicant = applicantList.get(i);
			if (!(pastWinnerList.contains(applicant))) {
				if (!(priorityList.contains(applicant))) {
					// 整数で扱いたいため+1
					// hitNum（当選番号）は1から始まる番号であるため
					normalIndexList.add(i + 1);
				} else {
					priorityIndexList.add(i + 1);
				}

			}
		}
		if (normalIndexList.size() + priorityIndexList.size() < 3) {
			return null;
		}
		// 重複しない当選番号が３つ揃うまでループ
		while (selectedIndexList.size() < 3) {

			// 1〜100の乱数
			int randomNum = random.nextInt(99) + 1;
			// 当選番号
			int selectedIndex;
			// 70%の当選確率であり、優先応募者がいる場合
			if (randomNum <= 70 && !(priorityIndexList.isEmpty())) {
				// 優先応募者リストからランダムに1人選んで、	
				// 当選番号（応募者リスト上の番号）を selectedIndex に代入する
				selectedIndex = priorityIndexList.get(random.nextInt(priorityIndexList.size()));
			} else if (!(normalIndexList.isEmpty())) {
				selectedIndex = normalIndexList.get(random.nextInt(normalIndexList.size()));
			} else {
				// 通常リストが空なら強制的に優先リストから選ぶ
				selectedIndex = priorityIndexList.get(random.nextInt(priorityIndexList.size()));
			}

			// 当選番号リストに重複がないか
			if (!(selectedIndexList.contains(selectedIndex))) {
				// 当選番号リストに当選番号を入れる
				selectedIndexList.add(selectedIndex);
			}
		}
		return selectedIndexList;

	}

	/**
	 * 当選者IDをwinneList.txtに追記保存する
	 */
	private static void writeToWinnerList(String winner) {
		// ファイルを読み込む
		String winnerListPath = "winnerList47.txt";
		// ファイルに当選者を書き出す
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(winnerListPath, true))) {
			bw.write(winner);
			// 改行
			bw.newLine();
		} catch (IOException e) {
			System.out.println("ファイルが見つかりませんでした。");
			e.printStackTrace();
		}
	}

	/**
	 * priorityList.txtを読み込んで応募者のIDを返す
	 */
	private static List<String> readPriorityList() {
		// ファイルを読み込む
		String priorityListPath = "priorityList47.txt";
		List<String> priorityIdList = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(priorityListPath))) {
			String priorityIdLine;
			while ((priorityIdLine = br.readLine()) != null) {
				priorityIdList.add(priorityIdLine);
			}
		} catch (FileNotFoundException e) {
			System.out.println("ファイルが見つかりませんでした。");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("読み込みエラーが発生しました。");
			e.printStackTrace();
		}
		return priorityIdList;
	}

}
