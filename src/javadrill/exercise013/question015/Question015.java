package javadrill.exercise013.question015;

import java.time.LocalDate;
import java.time.Period;

public class Question015 {

	public static void main(String[] args) {
		LocalDate currentDate = LocalDate.now();
		String birthdateStr = "1995-07-22";
		LocalDate birthdate = LocalDate.parse(birthdateStr);
		Period agePeriod = Period.between(birthdate, currentDate);
		int age = agePeriod.getYears();
		System.out.println(age);
	}

}
