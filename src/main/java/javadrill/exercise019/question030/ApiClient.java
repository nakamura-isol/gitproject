package javadrill.exercise019.question030;

/**
 * makeApiRequestメソッドは、RESTful APIとの通信をシミュレート
 * APIからのレスポンスのステータスコードを確認し、エラーレスポンスがあれば ApiRequestExceptionをスローする
 */
public class ApiClient {
	/**
	 * RESTful APIと通信するメソッド
	 * @throws ApiRequestException
	 */
	void makeApiRequest() throws ApiRequestException {
		// APIリクエストを実行し、エラーレスポンスがあれば例外をスローする
		int statusCode = 400;
		if (statusCode >= 400) {
			String errorMessage = "エラーレスポンスから取得したエラーメッセージ";
			throw new ApiRequestException(statusCode, errorMessage);
		}
		// 正常な処理を続行
		System.out.println("API Request Successful");
	}

}
