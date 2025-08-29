package javadrill.exercise013.question013;

import java.time.LocalDate;

public class Question013 {

	public static void main(String[] args) {
		// 例として、比較する2つの日付を作成
		LocalDate baseDate = LocalDate.of(2025, 8, 28);
		LocalDate targetDate = LocalDate.of(1995, 7, 22);
		compareDates(baseDate, targetDate);
	}

	private static void compareDates(LocalDate baseDate, LocalDate targetDate) {
		if (targetDate.isAfter(baseDate)) {
			System.out.println(targetDate + "は" + baseDate + "より後の日付です。");
		} else if (targetDate.isBefore(baseDate)) {
			System.out.println(targetDate + "は" + baseDate + "より前の日付です。");
		} else if (targetDate.equals(baseDate)) {
			System.out.println(targetDate + "は" + baseDate + "と同日です。");

		}

	}

}
