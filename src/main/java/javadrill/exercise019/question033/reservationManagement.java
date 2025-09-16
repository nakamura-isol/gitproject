package javadrill.exercise019.question033;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 予約管理プログラム
 */
public class reservationManagement {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/javadrill";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "matatavi022";

	public static void main(String[] args) {
		// ユーザーが予約
		try {
			manageReservation("多目的室", "20250905");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	/**
	 * 予約管理メソッド
	 */
	private static void manageReservation(String space, String date) throws SQLException {
		// データベースへの接続
		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);) {

			// トランザクション開始
			connection.setAutoCommit(false);
			// 指定された日時のスペースを取得する
			String targetSpace = getTargetSpace(connection, space, date);
			if (targetSpace != null) {
				connection.rollback();
				System.out.println("すでに予約が入ってます。");
				return;

			} else {
				// 登録処理
				// registerReservation();
				// トランザクションのコミット
				connection.commit();
				System.out.println("予約が完了しました。");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 指定された施設を取得する
	 * @return
	 * @throws SQLException 
	 */
	private static String getTargetSpace(Connection connection, String space, String date) throws SQLException {
		// 施設名と日時を条件に結果を取得するSQL文
		// 日時はnullか自分の希望日時以外ならOK
		String sql = "SELECT space FROM reservations WHERE space = ? and date =? ";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, space);
			statement.setString(2, date);
			// SQLの実行
			var resultSet = statement.executeQuery();
			if (resultSet.next()) {
				return resultSet.getString("space");
			} else {
				throw new SQLException("スペースが見つかりませんでした。");
			}

		}
	}

	/**
	 * 予約登録メソッド
	 * @throws SQLException 
	 */
	private static void registerReservation(Connection connection, String space, String date) throws SQLException {
		//
		String sql = "UPDATE space SET date = ? WHERE space = ? and date =? ";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, date);
			statement.setString(2, space);
			statement.setString(3, date);
			// SQLの実行
			statement.executeUpdate();
			// SQLの実行
			statement.executeUpdate();
		}
	}
}
