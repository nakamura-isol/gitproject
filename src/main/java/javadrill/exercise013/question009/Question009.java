package javadrill.exercise013.question009;

import java.text.NumberFormat;
import java.util.Locale;

public class Question009 {

	public static void main(String[] args) {
		// 1,000.50にしたい
		double num = 1.00050;
		// 通貨形式で整形
		// 通貨フォーマットで利用する通貨
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.JAPAN);
		// 桁区切り文字（,）を利用するか
		nf.setGroupingUsed(true);
		// 小数部分の最大桁数
		// 5桁まで許容（多めに設定しているだけ）
		nf.setMaximumFractionDigits(5);
		// 小数部分の最小桁数
		// 小数点以下の桁数も setMinimumFractionDigits(2) で 必ず2桁 表示される
		nf.setMinimumFractionDigits(2);
		System.out.println(nf.format(num));
	}

}
