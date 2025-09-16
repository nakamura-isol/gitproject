package javadrill.exercise007.question015;

public class Student {
	private String name;
	private int studentId;

	/**
	 * コンストラクタ
	 */
	Student(String name, int studentId) {
		this.name = name;
		this.studentId = studentId;

	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	int getStudentId() {
		return studentId;
	}

	void setStudentId(int studentId) {
		this.studentId = studentId;
	}
}
