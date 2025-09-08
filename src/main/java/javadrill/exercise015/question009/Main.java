package javadrill.exercise015.question009;

public class Main {

	public static void main(String[] args) {

		// Vehicle型の変数にSportsCarオブジェクトを代入（ポリモーフィズム）
		Vehicle vehicle = new SportsCar();

		// vehicleがSportsCar型にキャストできるか
		if (vehicle instanceof SportsCar) {
			// ダウンキャスト
			SportsCar sportsCar = (SportsCar) vehicle;
			sportsCar.startUp();
		} else {
			System.out.println("Vehicle is not a SportsCar");
		}

	}

}
