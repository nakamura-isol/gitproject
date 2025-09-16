package javadrill.exercise019.question032;
/**
 * 在庫管理プログラム
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InventoryManagement {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/javadrill";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "matatavi022";

	public static void main(String[] args) {
		try {
			// ユーザーが商品購入後の在庫変動例
			manageItem("002", 1);
			System.out.println("取引が成功しました。");
		} catch (SQLException | OutOfStockException e) {
			System.err.println("取引エラー: " + e.getMessage());
		}
	}

	/**
	 * 商品在庫管理メソッド
	 */
	private static void manageItem(String itemId, int numOfPurchased) throws SQLException, OutOfStockException {
		Connection connection = null;
		try {
			// データベースへの接続
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			// トランザクション開始
			connection.setAutoCommit(false);
			// 指定された商品在庫数を取得する
			int stock = checkStock(connection, itemId);
			if (stock < numOfPurchased) {
				throw new OutOfStockException("在庫不足です。現在在庫: " + stock + " / 必要数: " + numOfPurchased);
			}
			updateStock(connection, itemId, stock, numOfPurchased);
			// 正常終了
			connection.commit();
		} catch (SQLException | OutOfStockException e) {
			if (connection != null) {
				try {
					connection.rollback();
					// ロールバックに失敗しても仕方ないので無視する
				} catch (SQLException ignore) {

				}
			}
			// 呼び出し元へ再送出
			throw e;

		} finally {
			if (connection != null) {
				try {
					connection.setAutoCommit(true);
					connection.close();
				} catch (SQLException ignore) {

				}

			}
		}

	}

	/**
	 * 指定された商品の在庫数を取得するメソッド	
	 */
	private static int checkStock(Connection connection, String itemId) throws SQLException {
		String query = "SELECT stock FROM items WHERE item_id = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			// ? に商品IDをセット
			preparedStatement.setString(1, itemId);
			// SQLを実行して結果を受け取る(ResultSet)
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				// rs.next()で「次の行があるか」をチェック
				if (resultSet.next()) {
					// もし商品が存在すれば、その行のstockカラムの値を返す
					// 結果が0行ならfalse→ 「商品が見つからない」として例外に進む
					return resultSet.getInt("stock");
				}
			}

		}

		throw new SQLException("商品が見つかりません（item_id=" + itemId + "）。");

	}

	/**
	 * 商品の在庫数を更新するメソッド
	 */
	private static void updateStock(Connection connection, String itemId, int stock, int numOfPurchased)
			throws SQLException {
		String query = "UPDATE items SET stock = ? WHERE item_id = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			int newStock = stock - numOfPurchased;
			// 1番目: 新しい在庫
			preparedStatement.setInt(1, newStock);
			// 2番目: item_id
			preparedStatement.setString(2, itemId);
			int affectedRows = preparedStatement.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException("在庫更新に失敗しました（item_id=" + itemId + "）。");
			}

		}

	}
}
