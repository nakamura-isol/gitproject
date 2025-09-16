package javadrill.exercise007.question018;

public class Main {

	public static void main(String[] args) {
		
		Account account1 = new Account("123456789", "中村恵梨香", 1000000);
		Account account2 = new Account("123456789", "田中由梨恵", 2000000);

		Bank bank = new Bank();
		bank.addAccount(account1);
		bank.addAccount(account2);
		
		bank.displayTotalBalance();

		
	}

}
