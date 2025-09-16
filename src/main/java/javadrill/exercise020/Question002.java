package javadrill.exercise020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * ArrayListとLinkedListを使って、それぞれ先頭に新しい要素"Cherry"を追加し、リストを表示する
 */
public class Question002 {

	public static void main(String[] args) {
		ArrayList<String> colorsArrayList = new ArrayList<>(Arrays.asList("Red", "Green", "Blue"));
		LinkedList<String> colorsLinkedList = new LinkedList<>(Arrays.asList("Red", "Green", "Blue"));
		
		colorsArrayList.add(0, "Cherry");
		colorsLinkedList.addFirst("Cherry");
		
		System.out.println(colorsArrayList);
		System.out.println(colorsLinkedList);
		
	}

}
