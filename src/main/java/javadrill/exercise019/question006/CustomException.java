package javadrill.exercise019.question006;

import java.util.Scanner;

public class CustomException {

	public static void main(String[] args) {
		try {
			System.out.println("割られる数を入力してください。");
			int num1 = getInput();
			System.out.println("割る数を入力してください。");
			int num2 = getInput();
			divide(num1, num2);
		} catch (NumberFormatException e) {
			System.out.println("エラー: 数字以外が入力されました。");
		} catch (MyCustomException e) {
			System.out.println("エラー: " + e.getMessage());
		}
	}

	/**
	 * 割り算メソッド。2つの整数を受け取り、2つ目の整数が0であれば MyCustomExceptionをスローする
	 * @param num1
	 * @param num2
	 */
	static void divide(int num1, int num2) throws MyCustomException {
		if (num2 == 0) {
			throw new MyCustomException("0で割ることはできません。");
		}
		double result = num1 / num2;
		System.out.println(result);
	}

	/**
	 * ユーザーからの数値入力を受け付ける
	 * @return
	 * @throws NumberFormatException
	 */
	static int getInput() throws NumberFormatException {
		Scanner scanner = new Scanner(System.in);
		return Integer.parseInt(scanner.nextLine());
	}
}
