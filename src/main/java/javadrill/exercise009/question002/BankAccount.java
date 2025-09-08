package javadrill.exercise009.question002;

public class BankAccount {
	private double balance;

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		if (balance <= 0) {
			System.out.println("残高は負になりません。");
		} else {
			this.balance = balance;
		}

	}

}
