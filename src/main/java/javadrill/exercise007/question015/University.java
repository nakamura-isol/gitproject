package javadrill.exercise007.question015;

import java.util.ArrayList;
import java.util.List;

public class University {
	private String name;
	private List<Student> studentList;

	// コンストラクタ
	University(String name) {
		this.name = name;
		this.studentList = new ArrayList<>();
	}

	/**
	 * 学生リストを取得するメソッド
	 * @return
	 */
	List<Student> getStudentList() {
		return studentList;
	}

	/**
	 * 学生を追加するメソッド
	 * @param student
	 */
	void addStudent(Student student) {
		studentList.add(student);
	}

	/**
	 * 学生情報表示メソッド
	 */
	void displayStudents() {
		  System.out.println("University: " + name);
	        System.out.println("Students:");
		for (Student student : studentList) {
			System.out.println("- " + student.getName());

		}

	}
}
