import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Lesson24 {

	public static void main(String[] args) {
		System.out.println("日付をyyyy/MM/dd形式で入力してください");
		Scanner scImput = new Scanner(System.in);
		String imputDate = scImput.nextLine();
		getDate(imputDate);

	}

	private static void getDate(String targetDate) {
		// 日付フォーマット指定
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd");
		// Calendarインスタンスを取得
		Calendar calendar = Calendar.getInstance();

		try {
			// 対象日をDate型に変換
			Date dateTargetDate = sdFormat.parse(targetDate);

			// 前日、翌日を取得
			Date yesterday = getYesterday(dateTargetDate);
			Date tomorrow = getTomorrow(dateTargetDate);

			// 前日、翌日ををString型に変換
			String stringYesterday = new SimpleDateFormat("yyyy/MM/dd").format(yesterday);
			String stringTomorrow = new SimpleDateFormat("yyyy/MM/dd").format(tomorrow);

			System.out.println("昨日：" + stringYesterday + getDayOfTheWeek(yesterday));
			System.out.println("今日：" + targetDate + getDayOfTheWeek(dateTargetDate));
			System.out.println("翌日：" + stringTomorrow + getDayOfTheWeek(tomorrow));

		} catch (ParseException e) {

			e.printStackTrace();
		}

	}

	//前日を取得
	private static Date getYesterday(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, -1);
		return cal.getTime();
	}

	//翌日を取得
	private static Date getTomorrow(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, 1);
		return cal.getTime();

	}

	/**
	 * 現在の曜日を返す
	 * @return	現在の曜日
	 */
	private static String getDayOfTheWeek(Date targetDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(targetDate);
		switch (cal.get(Calendar.DAY_OF_WEEK)) {
		case Calendar.SUNDAY:
			return "（日）";
		case Calendar.MONDAY:
			return "（月）";
		case Calendar.TUESDAY:
			return "（火）";
		case Calendar.WEDNESDAY:
			return "（水）";
		case Calendar.THURSDAY:
			return "（木）";
		case Calendar.FRIDAY:
			return "（金）";
		case Calendar.SATURDAY:
			return "（土）";
		}
		throw new IllegalStateException();
	}

}
