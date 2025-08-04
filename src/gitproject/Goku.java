package gitproject;

/**
 * 悟空クラス
 */
public class Goku extends CharacterBase {

	/**
	 * コンストラクタ
	 */
	public Goku() {
		this.name = "悟空";
		this.hp = 100;
		this.atk = 20;
		this.atkRate = 2.0;

	}

	/**
	 * オリジナル攻撃メソッド
	 */
	@Override
	public int originalAttack() {
		System.out.println(this.name + "のかめはめ波！");
		int damage = (int) (this.atk * this.atkRate);
		System.out.println("相手に" + damage + "のダメージ！");
		return damage;
	}

}
