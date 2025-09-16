package javadrill.exercise007.question018;

import java.util.ArrayList;
import java.util.List;

public class Bank {
	private List<Account> accountList = new ArrayList<>();

	void addAccount(Account account) {
		accountList.add(account);
	}

	void displayTotalBalance() {
		double totalBalance = 0;
		for (Account account : accountList) {
			totalBalance += account.getBalance();

		}
		System.out.println("口座残高：" + totalBalance);
	}
}
