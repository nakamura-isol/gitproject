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
public class Lesson46 {

	public static void main(String[] args) {
		//応募者を取得
		List<String> applicantList = readAppList();
		//過去の当選者を取得
		List<String> pastWinnerList = readWinnerList();
		if (applicantList.size() == pastWinnerList.size()) {
			System.out.println("全員が過去に当選済みです。抽選対象がいません。");
			//途中で抜ける（処理中断）
			return;
		}
		//当選番号を取得
		List<Integer> hitNums = getHitNum(applicantList, pastWinnerList);
		if (hitNums == null) {
			System.out.println("抽選対象者が３人未満です。");
		} else {
			//応募者のインデックスと当選番号を比較する
			//Listの値を取得する際、インデックスは0から始まるので-1にする
			for (int hitNum : hitNums) {
				String winner = applicantList.get(hitNum - 1);
				System.out.println(winner);
				//当選者を保存追記
				writeToWinnerList(winner);
			}
		}
	}

	/**
	 * appList.txtを読み込んで全応募者のIDを返す
	 *
	 */
	private static List<String> readAppList() {
		String filePath = "appList.txt";
		List<String> idList = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String idLine;
			while ((idLine = br.readLine()) != null) {
				//応募者IDを全て読み込む
				idList.add(idLine);
			}
		} catch (FileNotFoundException e) {
			System.out.println("ファイルが見つかりませんでした。");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("読み込みエラーが発生しました。");
			e.printStackTrace();
		}
		return idList;
	}

	/**
	 * winnerList.txtを読み込んで過去の当選者を返す
	 */
	private static List<String> readWinnerList() {
		//ファイル読み込む
		String winnersTxtPath = "winnerList.txt";
		List<String> pastWinnerList = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(winnersTxtPath))) {
			String pastWinnerLine;
			while ((pastWinnerLine = br.readLine()) != null) {
				pastWinnerList.add(pastWinnerLine);
			}
		} catch (FileNotFoundException e) {
			System.out.println("ファイルが見つかりませんでした。");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("読み込みエラーが発生しました。");
			e.printStackTrace();
		}
		return pastWinnerList;
	}

	/**
	 * 当選番号を出す
	 * @return
	 */
	private static List<Integer> getHitNum(List<String> applicantList, List<String> pastWinnerList) {
		Random random = new Random();
		//当選番号のリスト
		List<Integer> selectedIndexList = new ArrayList<>();
		//当選対象者のインデックスリスト
		List<Integer> eligibleAppIndexList = new ArrayList<>();
		//応募者リストから過去の当選者以外を取得し、当選対象者のインデックスリストに格納する
		for (int i = 0; i < applicantList.size(); i++) {
			String applicant = applicantList.get(i);
			if (!(pastWinnerList.contains(applicant))) {
				eligibleAppIndexList.add(i + 1);
			}
		}
		if (eligibleAppIndexList.size() < 3) {
			return null;
		}
		// 重複しない当選番号が３つ揃うまでループ
		while (selectedIndexList.size() < 3) {
			// 1から応募者数の中で３つ選ぶ
			int randomIndex = random.nextInt(eligibleAppIndexList.size());
			// 当選対象者リストからランダムに選ばれたインデックス
			int selectedIndex = eligibleAppIndexList.get(randomIndex);
			// 当選番号リストに重複がないか
			if (!(selectedIndexList.contains(selectedIndex))) {
				// 当選番号リストに当選番号を入れる
				selectedIndexList.add(selectedIndex);
			}
		}
		return selectedIndexList;

	}

	/**
	 * 当選者IDをwinners.txtに追記保存する
	 */
	private static void writeToWinnerList(String winner) {
		//ファイルを読み込む
		String winnersTxtPath = "winnerList.txt";
		//ファイルに当選者を書き出す
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(winnersTxtPath, true))) {
			bw.write(winner);
			//改行
			bw.newLine();
		} catch (IOException e) {
			System.out.println("ファイルが見つかりませんでした。");
			e.printStackTrace();
		}
	}

}
