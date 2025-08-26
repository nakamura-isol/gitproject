package javadrill.exercise007.question015;

public class Student {
	String name;
	int studentId;

	/**
	 * コンストラクタ
	 */
	Student(String name, int studentId) {
		this.name = name;
		this.studentId = studentId;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
}
