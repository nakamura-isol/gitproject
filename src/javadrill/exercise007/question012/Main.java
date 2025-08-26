package javadrill.exercise007.question012;

public class Main {

	public static void main(String[] args) {
		BankAccount bankAccount = new BankAccount(1000);
		bankAccount.displayBalance();

		bankAccount.doposit(100);
		bankAccount.displayBalance();

		bankAccount.withdraw(1000);
		bankAccount.displayBalance();
	}

}
