package javadrill.exercise019.question027;

public class Account {

	private int accountNumber;
	private double balance;

	Account(int accountNumber, double balance) {
		this.accountNumber = accountNumber;
		this.balance = balance;

	}

	int getAccountNumber() {
		return accountNumber;
	}

	double getBalance() {
		return balance;
	}
}
