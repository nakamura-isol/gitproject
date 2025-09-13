package javadrill.exercise020.question007;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * 与えられたリストのイテレーターを使用して、要素を逆順に表示する
 */
public class Question007 {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		// リストの末尾に位置するListIteratorを取得
		ListIterator<Integer> iterator = numbers.listIterator(numbers.size());
		
		 // 前に要素がある間ループ
		while(iterator.hasPrevious()){
			   // 要素を逆順に取得して表示
			Integer element = iterator.previous();
				System.out.println(element);
		}

	}

}
