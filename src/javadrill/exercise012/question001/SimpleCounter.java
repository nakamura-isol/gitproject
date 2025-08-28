package javadrill.exercise012.question001;

public class SimpleCounter {

	/**
	 * static変数 
	 */
	private static int totalCount = 0;
	/**
	 * インスタンス変数
	 */
	private int instanceCount;
	/**
	 * コンストラクタ
	 */
	SimpleCounter() {
		totalCount++;
		instanceCount = 0;
	}
	/**
	 * インスタンスごとのカウントを増やすメソッド
	 */
	void incrementInstanceCount() {
		instanceCount++;
	}

	/**
	 * カウントされた回数を取得するクラスメソッド
	 * @return
	 */
	static int getTotalCount() {
		return totalCount;
	}

	 /**
	 * instanceCount を取得する
	 * @return
	 */
	 int getInstanceCount() {
	 return instanceCount;
	 }
}
