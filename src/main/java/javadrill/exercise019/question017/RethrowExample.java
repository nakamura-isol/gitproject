package javadrill.exercise019.question017;

public class RethrowExample {

	public static void main(String[] args) {
		try {
			performOperation();
		} catch (CustomException e) {
			System.out.println("メインメソッド: " + e.getMessage());
		}
	}

	static void performOperation() throws CustomException {
		try {
			// 何らかの操作を試みる
			System.out.println("例外処理です。");
		} catch (Exception e) {
			// CustomExceptionに変換して再スローするコードを追加
			throw new CustomException("カスタム例外が発生しました。");
		}
	}
}

class CustomException extends Exception {
	CustomException(String message) {
		super(message);

	}
}
