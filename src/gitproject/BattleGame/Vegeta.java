package gitproject.BattleGame;

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
		this.atk = 20;
		this.atkRate = 2.0;
	}

	@Override
	public int originalAttack(String damagedChara) {
		System.out.println(this.name + "のギャリック砲！");
		int damage = (int) (this.atk * this.atkRate);
		System.out.println(damagedChara + "に" + damage + "のダメージ！");
		return damage;
	}

	@Override
	public int originalAttack() {
		System.out.println(this.name + "のギャリック砲！");
		int damage = (int) (this.atk * this.atkRate);
		System.out.println("相手に" + damage + "のダメージ！");
		return damage;
	}
}
