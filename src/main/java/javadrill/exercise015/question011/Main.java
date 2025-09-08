package javadrill.exercise015.question011;
/**
 * インスタンスが特定の型であるかを確認後ダウンキャストし、NullPointerExceptionを回避する
 */
public class Main {

	public static void main(String[] args) {
		// インスタンスの実際の型が不明なオブジェクト
		Object unknownObject = getUnknownObject();

		// 対象が継承関係だったらダウンキャスト（親→子）する
		// AnimalからCatにする
		// nullチェックを行ってからインスタンスが特定の型であるかを確認してからダウンキャスト
		if (unknownObject == null) {
			System.out.println("The object is null");
		} else {
			if (unknownObject instanceof Animal) {
				Animal animal = (Animal) unknownObject;
				animal.makeSound();
			} else {
				System.out.println("The object is not of the expected type");
				return;
			}
		}
	}

	// 仮のメソッド：実際のアプリケーションでは適切な方法でオブジェクトを取得
	private static Object getUnknownObject() {
		// Animalクラスのインスタンスを返す
		return new Animal();
		// または null を返すこともあります
		// return null;
	}
}
