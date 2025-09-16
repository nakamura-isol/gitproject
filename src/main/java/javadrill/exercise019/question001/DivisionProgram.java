package javadrill.exercise019.question001;

import java.util.Scanner;

public class DivisionProgram {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
	
		try {
			// ユーザーに整数を入力させるコードを記述
			System.out.println("最初の整数を入力してください。");

			int inputedNum1 = scanner.nextInt();
			System.out.println("次の整数を入力してください。");

			int inputedNum2 = scanner.nextInt();
			// 除算結果を計算して表示
			int result = inputedNum1 / inputedNum2;

		} catch (ArithmeticException e) {
			System.out.println("0で割ることはできません");
		} finally {
			scanner.close();
		}

	}

	private static int nextInt() {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

}
