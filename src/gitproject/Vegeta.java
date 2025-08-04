package gitproject;

/**
 * ベジータクラス
 */
public class Vegeta extends CharacterBase {
	/**
	 * コンストラクタ
	 */
	public Vegeta() {
		this.name = "ベジータ";
		this.hp = 100;
		this.atk = 18;
		this.atkRate = 1.8;
	}

	@Override
	public int originalAttack() {
		System.out.println(this.name + "のギャリック砲！");
		int damage = (int) (this.atk * this.atkRate);
		System.out.println("相手に" + damage + "のダメージ！");
		return damage;
	}
}
