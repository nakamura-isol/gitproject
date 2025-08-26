package javadrill.exercise007.question012;

public class BankAccount {
	int balance;

	/**
	 * 初期残高を指定できるコンストラクタ
	 * @param balance
	 */
	BankAccount(int price) {
		if (price >= 0) {
			this.balance = price;
		} else {
			System.out.println("エラー: 初期残高は負にすることはできません。残高は 0 に設定されます。");
			this.balance = 0;
		}
	}

	/**
	 * 預金メソッド
	 * @param price
	 */
	public void doposit(int price) {
		if (price > 0) {
			this.balance += price;
			System.out.println(price + " 円を預金しました。");
		} else {
			System.out.println("0円以下の金額は受け付けません。");
		}

	}

	/**
	 * 引き出しメソッド（口座残高から指定された金額を引きます。ただし、残高が不足していないか確認する）
	 * @return
	 */
	public void withdraw(int price) {
		// 残高不足してないかチェック
		// 0円以上で残高以内の金額
		if (price > 0 && price <= this.balance) {
			this.balance -= price;
			System.out.println("引き出しました。");
		} else {
			System.out.println("エラー: 引き出し額が正しくないか、残高不足です。");
		}

	}

	/**
	 * 残高表示メソッド
	 */
	public void displayBalance() {
		System.out.println("残高：" + this.balance + " 円");
	}
}
