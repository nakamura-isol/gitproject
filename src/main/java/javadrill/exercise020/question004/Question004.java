package javadrill.exercise020.question004;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * 与えられたリストのイテレーターを使用して、各要素を順番に表示する
 */
public class Question004 {

	public static void main(String[] args) {
		List<String> colors = Arrays.asList("Red", "Green", "Blue", "Yellow", "Orange");
		ListIterator<String> iterator = colors.listIterator();		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}

	}

}
