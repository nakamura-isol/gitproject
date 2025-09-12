package javadrill.exercise019.question030;

/**
 * ApiClientを使用してAPIリクエストを実行し、ApiRequestExceptionをキャッチして適切な処理を行う
 */
public class Main {

	public static void main(String[] args) {
		ApiClient apiClient = new ApiClient();
		try {
			apiClient.makeApiRequest();
		} catch (ApiRequestException e) {
			// 他の例外処理やリトライロジックなどを追加することができる
			System.out.println("API Request Failed: " + e.getStatusCode() + ", " + e.getErrorMessage());

		}

	}

}
