package javadrill.exercise011.question004;

public class Car {
	private String brand;
	private String model;

	// デフォルトコンストラクタ
	Car() {
		this.brand = "Unknown";
		this.model = "Unknown";
	}

	// 引数を受け取るコンストラクタ
	Car(String brand, String model) {
		this.brand = brand;
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

}
