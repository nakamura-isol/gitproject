package javadrill.exercise011.question001;

public class Person {
	private String name;
    private int age;
    
    public Person(){
    	name = "未設定";
    	age = 0;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
