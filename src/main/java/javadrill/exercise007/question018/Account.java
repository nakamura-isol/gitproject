package javadrill.exercise007.question018;

public class Account {

	private String accountNumber;
	private String accountHolder;
	private double balance;

	Account(String accountNumber, String accountHolder, double balance) {
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
		this.balance = balance;
	}
	
	void displayAccountInfo(){
		System.out.println("口座番号："+accountNumber);
		System.out.println("口座名義人："+accountHolder);
		System.out.println("残高："+balance);

		
	}

	String getAccountNumber() {
		return accountNumber;
	}

	void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	String getAccountHolder() {
		return accountHolder;
	}

	void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	double getBalance() {
		return balance;
	}

	void setBalance(double balance) {
		this.balance = balance;
	}
}
