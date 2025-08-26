package javadrill.exercise007.question015;

public class Main {

	public static void main(String[] args) {
		// 複数の学生を大学に追加し、その一覧を表示
		
		Student student1 = new Student("中村恵梨香",1111);
		Student student2 = new Student("山田太郎",2222);

		University university = new University();
		university.addStudent(student1);
		university.addStudent(student2);
		
		university.displayStudents();
	}

}
