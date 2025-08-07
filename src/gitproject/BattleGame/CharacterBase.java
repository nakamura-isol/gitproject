package gitproject.BattleGame;

public abstract class CharacterBase {
	protected String name;
	protected int hp;
	protected int atk;
	protected double atkRate;

	/**
	 * キャラクター共通の技
	 */
	public int commonAttack() {
		System.out.println(name + "のパンチ！");
		System.out.println("相手に" + atk + "のダメージ！");
		return atk;

	}

	/**
	 * キャラクター共通の技
	 * @param damagedChara
	 * @return
	 */
	public int commonAttack(String damagedChara) {
		System.out.println(name + "のパンチ！");
		System.out.println(damagedChara + "に" + atk + "のダメージ！");
		return atk;

	}

	/**
	 * キャラクター固有の技（後でオーバライドする）
	 */
	public abstract int originalAttack();

	/**
	 * キャラクター固有の技（後でオーバライドする）
	 */
	public abstract int originalAttack(String damagedChara);

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public double getAtkRate() {
		return atkRate;
	}

	public void setAtkRate(double atkRate) {
		this.atkRate = atkRate;
	}

	// public int originalAttack() {
	// return 0;
	// }

}
