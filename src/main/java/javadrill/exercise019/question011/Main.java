package javadrill.exercise019.question011;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("最初の整数を入力してください。");
		try {
			String num1 = sc.nextLine();
			int a = convert(num1);
			System.out.println("2つ目の整数を入力してください。");
			String num2 = sc.nextLine();
			int b = convert(num2);
			int result = a / b;
			System.out.println(result);
		} catch (ArithmeticException e) {
			System.out.println("0で割ることはできません。");
		} catch (InputMismatchException e) {
			System.out.println("整数以外の数字が入力されました。");
		}

	}

	private static int convert(String str) {
		return Integer.parseInt(str);
	}

}
