package gitproject.BattleGame;

/**
 * ピッコロクラス
 */
public class Piccolo extends CharacterBase {
	/**
	 * コンストラクタ
	 */
	public Piccolo() {
		this.name = "ピッコロ";
		this.hp = 100;
		this.atk = 10;
		this.atkRate = 1.0;
	}

	@Override
	public int originalAttack(String damagedChara) {
		System.out.println(this.name + "の魔貫光殺法！");
		int damage = (int) (this.atk * this.atkRate);
		System.out.println(damagedChara + "に" + damage + "のダメージ！");
		return damage;
	}

	@Override
	public int originalAttack() {
		System.out.println(this.name + "の魔貫光殺法！");
		int damage = (int) (this.atk * this.atkRate);
		System.out.println("相手に" + damage + "のダメージ！");
		return damage;
	}

}
