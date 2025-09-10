package javadrill.exercise019.question019;

public class RethrowAndChainExample {
	public static void main(String[] args) {
		try {
			performOperation();
		} catch (CustomException e) {
			System.out.println("メインメソッド: " + e.getMessage());
			System.out.println("原因: " + e.getCause().getMessage());
		}
	}

	static void performOperation() throws CustomException {
		try {
			// 例外を発生させるためのダミーコード
			int result = 10 / 0;
		} catch (Exception e) {
			CustomException customException = new CustomException("カスタムされた例外です。");
			// 元の例外を設定
			customException.initCause(e);
			throw customException;
		}
	}

}
