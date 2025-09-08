package javadrill.exercise013.question012;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Question012 {

	public static void main(String[] args) {
		LocalDate today = LocalDate.of(2025,8,28);
		System.out.println(today);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
		System.out.println(dtf.format(today));
	}

}
