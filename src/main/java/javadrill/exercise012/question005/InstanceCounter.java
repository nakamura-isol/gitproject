package javadrill.exercise012.question005;

public class InstanceCounter {
	/**
	 * static変数
	 */
	private static int staticInstanceCount =0;
	
	/**
	 * インスタンス変数（クラス生成度増える）
	 */
	private int instanceCount;

	static int getInstanceCount() {
		return staticInstanceCount;
	}

	/**
	 * コンストラクタ
	 */
	InstanceCounter(){
		staticInstanceCount++;
	}
}
