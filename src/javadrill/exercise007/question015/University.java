package javadrill.exercise007.question015;

import java.util.ArrayList;
import java.util.List;

public class University {
	List<Student>studentList = new ArrayList<>();
	
	
	/**
	 * 学生を追加するメソッド
	 * @param student
	 */
	public void addStudent(Student student) {
		studentList.add(student);
	}
	/**
	 * 学生情報表示メソッド
	 */
	public void displayStudents() {
		for(Student student:studentList) {
			System.out.println(student.getName()+"\t"+student.getStudentId());
			
		}
		
	}
}
