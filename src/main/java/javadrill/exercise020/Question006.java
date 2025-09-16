package javadrill.exercise020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * 与えられたリストのイテレーターを使用して、文字列の長さが3未満の要素を削除してリストを表示する
 */
public class Question006 {

	public static void main(String[] args) {
		List<String> words = new ArrayList<>(Arrays.asList("Cat", "Dog", "Elephant", "Ant", "Lion", "Tiger"));
		ListIterator<String> iterator = words.listIterator();
		while (iterator.hasNext()) {
			String word = iterator.next();
			if (word.length() < 3) {
				iterator.remove();
			}
		}
		System.out.println(words);
	}

}
