package javadrill.exercise019.question018;

import java.util.Scanner;

public class ExceptionPropagationAndThrowExample {

	public static void main(String[] args) {
		try {
			processInput();
		} catch (NumberFormatException e) {
			System.out.println("メインメソッド: " + e.getMessage());
		}

	}

	static void processInput() {
		System.out.println("整数を入力してください。");
		try (Scanner scanner = new Scanner(System.in);) {
			// 文字列で受け取る
			String input = scanner.nextLine();
			// ここでNFEが起きる可能性あり
			int inputedNum = Integer.parseInt(input);

			System.out.println(inputedNum);
		} catch (NumberFormatException e) {
			throw new NumberFormatException("整数以外の数字が入力されました。");
		}

	}
}
