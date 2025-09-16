package javadrill.exercise020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 与えられたリストの末尾に新しい要素"Dog"を追加し、その後リストを表示してください。
 */
public class Question001 {

	public static void main(String[] args) {
		List<String> animals = new ArrayList<>(Arrays.asList("Cat", "Elephant", "Monkey", "Lion"));
		animals.add("dog");
		System.out.println(animals);

	}

}
