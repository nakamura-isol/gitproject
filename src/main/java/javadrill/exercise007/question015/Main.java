package javadrill.exercise007.question015;

public class Main {

	public static void main(String[] args) {

		// 大学オブジェクトの作成
		University university1 = new University("日本女子大学");
		University university2 = new University("慶應義塾大学");

		// 学生オブジェクトの作成
		Student student1 = new Student("中村恵梨香", 1111);
		Student student2 = new Student("今井麻梨恵", 2222);

		// 各大学に学生を追加
		university1.addStudent(student1);
		university2.addStudent(student2);

		// 学生情報の表示
		university1.displayStudents();
		university2.displayStudents();
	}
}
