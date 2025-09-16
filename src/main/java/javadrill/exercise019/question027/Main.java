package javadrill.exercise019.question027;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/bank";
	private static final String DB_USER = "your_username";
	private static final String DB_PASSWORD = "your_password";

	public static void main(String[] args) {
		Account account = new Account(111222, 1000.0);
		
		
	}

	/**
	 * 銀行取引メソッド
	 */
	private static void transferFunds(int fromAccount, int toAccount, double money)
			throws SQLException, InsufficientFundsException {
		// データベースへの接続
		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
			// トランザクションの開始
			connection.setAutoCommit(false);
			// 現在の残高
			double balance = getAccountBalance(connection, fromAccount);

		}

	}

	/**
	 * 指定されたアカウントの残高を取得するメソッド
	 * @param connection
	 * @param accountNumber
	 * @return
	 * @throws SQLException
	 */
	private static double getAccountBalance(Connection connection, int accountNumber) throws SQLException {
		String query = "SELECT balance FROM accounts WHERE account_number = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setDouble(1, accountNumber);
			var resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return resultSet.getDouble("balance");
			}

		}
		throw new SQLException("アカウントが見つかりません。");

	}
	// /**
	// * 引き落としメソッド
	// * @param connection
	// * @param accountNumber
	// * @return
	// * @throws SQLException
	// */
	// private static double Withdraw(Connection connection, int accountNumber,)
	// throws SQLException {
	// String query = "SELECT balance FROM accounts WHERE account_number = ?";
	// try (PreparedStatement preparedStatement =
	// connection.prepareStatement(query)) {
	// preparedStatement.setDouble(1, accountNumber);
	// var resultSet = preparedStatement.executeQuery();
	// if (resultSet.next()) {
	// return resultSet.getDouble("balance");
	// }
	//
	// }
	// throw new SQLException("アカウントが見つかりません。");
	//
	// }

	/**
	 * 取引後の残高を更新するメソッド
	 * @throws SQLException 
	 */
	private static void deposit(Connection connection, int accountNumber, double newBalance, double balance)
			throws SQLException {
		String query = "UPDATE accounts SET balance = ? WHERE account_number = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

			preparedStatement.setDouble(1, newBalance);
			preparedStatement.setInt(2, accountNumber);
			int affectedRows = preparedStatement.executeUpdate();
			// SQLを実行して更新できた行数をチェックする処理
			if (affectedRows == 0) {
				throw new SQLException("アカウントが見つかりません。");
			}
		}

	}

	/**
	 * 引き出しメソッド
	 * 取引金額分残高減らして、残高返す	
	 * @param accountNumber
	 * @param balance
	 */
	private static double withdraw(Connection connection, int accountNumber, double moneyOfWithdraw, double balance)
			throws SQLException {
		if (moneyOfWithdraw > balance) {
			System.out.println("残高以上の金額は下せません。");
			return balance;
		} else {
			return balance - moneyOfWithdraw;
		}
	}

	/**
	 * 振り込みメソッド
	 */
	private static void transfer(Connection connection, int fromAccountNumber, int toAccountNumber,
			double moneyOfTransfer) {
		

	}
}
