package gitproject.BattleGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ExLesson_02_BattleGame {
	public static void main(String[] args) {
		// 選択キャラリスト
		List<CharacterBase> charaList = new ArrayList<>();
		charaList.add(new Goku());
		charaList.add(new Vegeta());
		charaList.add(new Piccolo());

		// キャラ選択
		System.out.println("キャラクターを選択してください。");
		for (int i = 0; i < charaList.size(); i++) {
			System.out.println(i + 1 + ":" + charaList.get(i).getName());
		}

		Scanner sc = new Scanner(System.in);

		int inputedCharaNum;
		while (true) {
			if (sc.hasNextInt()) {
				inputedCharaNum = sc.nextInt();
				if (inputedCharaNum > 0 && inputedCharaNum <= charaList.size()) {
					break;
				} else {
					System.out.println("1~" + charaList.size() + "を入力してください。");
					continue;
				}
			} else {
				System.out.println("数値を入力してください。");
				// 文字列を読み飛ばす
				sc.next();
			}

		}
		// 選択キャラのプロフィール表示
		CharacterBase selectedChara = charaList.get(inputedCharaNum - 1);
		System.out.println(selectedChara.getName() + "を選択しました。");
		System.out.println("【HP:" + selectedChara.getHp() + "\t"
				+ "ATK:" + selectedChara.getAtk() + "】");
		System.out.println();

		// 敵キャラの登場
		Random random = new Random();
		int enemyCharaIndex;
		while (true) {
			enemyCharaIndex = random.nextInt(charaList.size());
			if (enemyCharaIndex != (inputedCharaNum - 1)) {
				break;
			}
		}
		// 敵キャラを取得
		CharacterBase enemyChara = charaList.get(enemyCharaIndex);
		System.out.println("敵の" + enemyChara.getName() + "が現れた！");
		System.out.println("【HP:" + enemyChara.getHp() + "\t"
				+ "ATK:" + enemyChara.getAtk() + "】");
		System.out.println();


		while (true) {
			// 敵キャラへの攻撃選択
			System.out.println("行動を選択してください。");
			System.out.println("1:技1" + "\n" + "2:技2");

			int inputedAttack;
			while (true) {
				if (sc.hasNextInt()) {
					inputedAttack = sc.nextInt();
					if (!(inputedAttack > 0 && inputedAttack <= 2)) {
						System.out.println("入力に誤りがあります。");
						continue;
					} else {
						break;
					}
				} else {
					System.out.println("数値を入力してください。");
					// 文字列を読み飛ばす
					sc.next();
				}
			}
			int damage = 0;
			// 自キャラの攻撃
			if (inputedAttack == 1) {
				damage = selectedChara.commonAttack(enemyChara.getName());
			} else if (inputedAttack == 2) {
				damage = selectedChara.originalAttack(enemyChara.getName());
			}

			boolean enemyCharaIsLoser = applyDamage(enemyChara, selectedChara, damage);
			if (enemyCharaIsLoser) {
				break;
			}

			// 敵キャラの攻撃
			int enemyCharaAttackIndex = random.nextInt(2) + 1;
			if (enemyCharaAttackIndex == 1) {
				damage = enemyChara.commonAttack(selectedChara.getName());
			} else if (enemyCharaAttackIndex == 2) {
				damage = enemyChara.originalAttack(selectedChara.getName());
			}

			boolean selectedCharaIsLoser = applyDamage(selectedChara, enemyChara, damage);
			if (selectedCharaIsLoser) {
				break;
			}

		}
		System.out.println("ゲームを終了します。");

	}

	/*
	 * 攻撃を受けた時の処理
	 */
	private static boolean applyDamage(CharacterBase damagedChara, CharacterBase attacker, int damage) {
		boolean isLoser = false;
		damagedChara.setHp(damagedChara.getHp() - damage);
		if (damagedChara.getHp() <= 0) {
			damagedChara.setHp(Math.max(damagedChara.getHp() - damage, 0));
			// HPを減らすが、HPが0未満にならないようにする
			System.out.println("【HP:" + damagedChara.getHp() + "\t" + "ATK:" + damagedChara.getAtk() + "】");
			System.out.println();
			System.out.println(attacker.getName() + "の勝ちです。");
			return isLoser = true;
		}
		System.out.println("【HP:" + damagedChara.getHp() + "\t" + "ATK:" + damagedChara.getAtk() + "】");
		System.out.println();
		return isLoser = false;
	}
}
