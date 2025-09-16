package javadrill.exercise018.question022;

import java.util.ArrayList;
import java.util.List;

public class ElementPrinter<T> {
	// フィールド署名にTを利用できる
	private T t;
	// ジェネリクスを使用したフィールドにTが使用できる
	private List<T> list = new ArrayList<T>();

	ElementPrinter(T t) {
		this.t = t;
	}

	T getT() {
		return t;
	}

	List<T> getList() {
		return list;
	}
	/**
	 * 任意の型のリストを受け取り、要素を順番に表示する
	 */
	void printElements(List<T> list){
		for(T t:list) {
			System.out.println(t);
			
		}
	}

	

}
