package gitproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * レンタルプログラム
 */
public class Lesson48 {
	public static String rentalCsv = "rental.csv";

	public static void main(String[] args) {
		System.out.println("１：貸出処理を行う\n２：返却処理を行う");
		List<BookRental> bookRentalList = readRentalCsv();
		Scanner sc = new Scanner(System.in);
		int inputedNum = 0;
		while (true) {
			try {
				inputedNum = sc.nextInt();
				// 改行の吸収
				sc.nextLine();
				if (inputedNum == 1) {
					lendBook(bookRentalList);
					break;
				} else if (inputedNum == 2) {
					returnBook(bookRentalList);
					break;
				} else {
					System.out.println("1か2を入力してください。");
				}
			} catch (Exception e) {
				System.out.println("数値を入力してください。");
				// 入力バッファクリア
				sc.nextLine();
			}
		}
	}

	/**
	 * 貸出処理
	 */
	private static void lendBook(List<BookRental> bookRentalList) {
		System.out.println("借りるタイトルを入力してください。");
		Scanner sc = new Scanner(System.in);
		String bookTitle = sc.nextLine();
		for (int i = 0; i < bookRentalList.size(); i++) {
			// タイトルが一致したら
			if (bookTitle.equals(bookRentalList.get(i).getTitle())) {
				// 日付が入力されていたら貸出中
				if (bookRentalList.get(i).getDate() != null) {
					System.out.println("貸出中のタイトルです。");
					return;
				} else {
					System.out.println("貸出可能なタイトルです。");

					// 現在日時の取得
					Date dateSysDay = new Date();
					// 書式の作成
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
					// String型に
					String stringSysDay = sdf.format(dateSysDay);

					bookRentalList.get(i).setDate(stringSysDay);

					// 上書き保存
					try (BufferedWriter bw = new BufferedWriter(new FileWriter(rentalCsv))) {
						for (BookRental bookRental : bookRentalList) {
							if (bookRental.getDate() == null) {
								bw.write(bookRental.getTitle());
								bw.newLine();
							} else {
								bw.write(bookRental.getTitle() + "、" + bookRental.getDate());
								bw.newLine();
							}
						}
					} catch (FileNotFoundException e) {
						System.out.println("ファイルが見つかりませんでした。");
						e.printStackTrace();
					} catch (IOException e) {
						System.out.println("読み込みエラーが発生しました。");
						e.printStackTrace();
					}
					LocalDate returnDate = getReturnDate(stringSysDay);

					// DateTimeFormatterを使用して、yyyy/MM/ddの形式で書式設定
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
					String StringReturnDate = returnDate.format(dtf);
					System.out.println("貸出処理を実施しました。返却期限は" + StringReturnDate + "です。");
					return;

				}
			}
		}
		// for文を最後まで回ってもreturnされなかった→ 一致なし
		System.out.println("存在しないタイトルです。");

	}

	/**
	 * 返却処理
	 */
	private static void returnBook(List<BookRental> bookRentalList) {
		System.out.println("返却するタイトルを入力してください。");
		Scanner sc = new Scanner(System.in);
		String bookTitle = sc.nextLine();
		for (int i = 0; i < bookRentalList.size(); i++) {
			if (bookTitle.equals(bookRentalList.get(i).getTitle())) {
				if (bookRentalList.get(i).getDate() == null) {
					System.out.println("現在貸し出されていないタイトルです。");
					return;
				}
				// 現在日付を取得
				LocalDate localDateSysDate = LocalDate.now();

				try {
					// 書式の作成
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
					// 借りた日（String型に）
					String borrowedDay = bookRentalList.get(i).getDate();
					// Date型に変換
					Date dateBorrowedDay = sdf.parse(borrowedDay);
					// Date型になったので、String型として書式を整える
					String stringBorrowedDay = sdf.format(dateBorrowedDay);
					LocalDate localDateReturnDate = getReturnDate(stringBorrowedDay);

					// 返却日に空文字
					bookRentalList.get(i).setDate("");

					// ファイル更新（上書き）
					try (BufferedWriter bw = new BufferedWriter(new FileWriter(rentalCsv));) {
						for (BookRental bookRental : bookRentalList) {
							if (bookRental.getDate() == null) {
								bw.write(bookRental.getTitle());
								bw.newLine();
							} else {
								bw.write(bookRental.getTitle() + "、" + bookRental.getDate());
								bw.newLine();
							}
						}

					} catch (FileNotFoundException e) {
						System.out.println("ファイルが見つかりませんでした。");
						e.printStackTrace();
					} catch (IOException e) {
						System.out.println("読み込みエラーが発生しました。");
						e.printStackTrace();
					}

					// 返却期限を過ぎていた場合
					if (localDateSysDate.isAfter(localDateReturnDate)) {
						long delayPeriod = java.time.temporal.ChronoUnit.DAYS.between(localDateReturnDate,
								localDateSysDate);
						System.out.println("返却処理を実施しました。" + delayPeriod + "日間延滞しています。");

					} else {
						System.out.println("返却処理を実施しました。");
					}
				} catch (ParseException e) {
					System.out.println("日付の変換に失敗しました。");
					e.printStackTrace();
				}

				// 見つかったので処理終了
				return;
			}

		}
		System.out.println("存在しないタイトルです。");

	}

	/**
	 * rental.csvを読み込んでデータを返す
	 */
	private static List<BookRental> readRentalCsv() {
		List<BookRental> rentalList = new ArrayList();
		try (BufferedReader br = new BufferedReader(new FileReader(rentalCsv))) {
			String line;
			while ((line = br.readLine()) != null) {
				// 行をカンマで分割（CSV形式）
				String[] parts = line.split("、");
				if (parts.length == 2) {
					String title = parts[0].trim();
					String date = parts[1].trim();
					rentalList.add(new BookRental(title, date));
				}
				if (parts.length == 1) {
					String title = parts[0].trim();
					String date = null;
					rentalList.add(new BookRental(title, date));
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("ファイルが見つかりませんでした。");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("読み込みエラーが発生しました。");
			e.printStackTrace();
		}
		return rentalList;

	}

	/**
	 * 返却日を返す
	 * @param bookTitle
	 * @param bookRentalList
	 * @return
	 */
	private static LocalDate getReturnDate(String date) {
		// 現在日時（LocalDate）
		LocalDate localDateSysDay = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		// 7日後の日付を計算
		LocalDate localDateReturnDate = localDateSysDay.plusDays(7);
		return localDateReturnDate;

	}

}
