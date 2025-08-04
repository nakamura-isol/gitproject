package gitproject;

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
				if (inputedCharaNum > 0 && inputedCharaNum <= 3) {
					break;
				} else {
					System.out.println("1~3を入力してください。");
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
		System.out.println(selectedChara.getName() + "を選択");
		System.out.println("【HP:" + selectedChara.getHp() + "\t"
				+ "ATK:" + selectedChara.getAtk() + "】");

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
			// 敵キャラに攻撃
			if (inputedAttack == 1) {
				damage = selectedChara.commonAttack();
			} else if (inputedAttack == 2) {
				damage = selectedChara.originalAttack();
			}
			// 敵キャラのダメージを反映
			enemyChara.setHp(enemyChara.getHp() - damage);
			if (enemyChara.getHp() <= 0) {
				enemyChara.setHp(Math.max(enemyChara.getHp() - damage, 0));
				// HPを減らすが、HPが0未満にならないようにする
				System.out.println("【HP:" + enemyChara.getHp() + "\t" + "ATK:" + enemyChara.getAtk() + "】");

				System.out.println(selectedChara.getName() + "の勝ちです。");
				break;
			}

			System.out.println("【HP:" + enemyChara.getHp() + "\t" + "ATK:" + enemyChara.getAtk() + "】");

			// 敵キャラの攻撃
			int enemyCharaAttackIndex = random.nextInt(2) + 1;
			if (enemyCharaAttackIndex == 1) {
				damage = enemyChara.commonAttack();
			} else if (enemyCharaAttackIndex == 2) {
				damage = enemyChara.originalAttack();
			}
			// 選択キャラのダメージを反映
			selectedChara.setHp(selectedChara.getHp() - damage);
			if (selectedChara.getHp() <= 0) {
				selectedChara.setHp(Math.max(selectedChara.getHp() - damage, 0));
				System.out.println("敵の" + enemyChara.getName() + "の勝ちです。");
				break;
			}
			System.out.println("【HP:" + selectedChara.getHp() + "\t" + "ATK:" + selectedChara.getAtk() + "】");

		}
		System.out.println("ゲームを終了します。");
	}

}
