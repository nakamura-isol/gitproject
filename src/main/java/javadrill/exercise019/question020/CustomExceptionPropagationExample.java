package javadrill.exercise019.question020;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomExceptionPropagationExample {
	public static void main(String[] args) {
		try {
			processInput();
		} catch (CustomInputException e) {
			System.out.println("メインメソッド: " + e.getMessage());
		}
	}

	static void processInput() throws CustomInputException {
		System.out.println("数字を入力してください。");
		Scanner scanner = new Scanner(System.in);
		try {
			int inputedNum = scanner.nextInt();

		} catch (InputMismatchException e) {
			throw new CustomInputException("数字を入力してください。", e);

		}

	}
}

class CustomInputException extends Exception {
	CustomInputException(String mesage, Throwable cause) {
		super(mesage, cause);
	}
}
