package javadrill.exercise019.question030;

/**
 * RESTful APIリクエスト中にエラーレスポンスが返された場合にスローされるカスタム例外クラス
 * コンストラクタでステータスコードとエラーメッセージを受け取り、それらを含むエラーメッセージを生成する
 */
public class ApiRequestException extends Exception {
	private int statusCode;
	private String errorMessage;

	ApiRequestException(int statusCode, String errorMessage) {
		super("API Request Failed with status code: " + statusCode + ", Error: " + errorMessage);
		this.statusCode = statusCode;
		this.errorMessage = errorMessage;
	}

	int getStatusCode() {
		return statusCode;
	}

	void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	String getErrorMessage() {
		return errorMessage;
	}

	void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
