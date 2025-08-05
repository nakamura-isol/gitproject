package gitproject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Calculation {
	/**
	 * 税込み価格を返す
	 * 小数点以下は切り捨てる
	 * @param price
	 * @return
	 */
	public static int getPriceIncludingTax(int price, Date parchaseDate) {
		int priceIncludingTax = 0;
		double taxRate;
		String stringDateOfTaxRevision = "20191001";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		try {
			Date dateDateOfTaxRevision = sdf.parse(stringDateOfTaxRevision);
			// 2019年10月1日以前は8%、それ以降は10%
			if (parchaseDate.before(sdf.parse(stringDateOfTaxRevision))
					|| parchaseDate.equals(sdf.parse(stringDateOfTaxRevision))) {
				taxRate = 0.08;
			} else {
				taxRate = 0.10;
			}
			double taxed = price * (1 + taxRate);
			priceIncludingTax = (int) Math.floor(taxed);
			return priceIncludingTax;

		} catch (ParseException e) {
			System.out.println("日付型に変換できませんでした。");
		}
		// 税率適用できない場合は元の値を返す
		return price;

	}

}
