// This class describes the person's attributes
package ex01AgeVerification;

public class Person {

	// Attributes
	private String name;
	private int age;
	private boolean isValidAge;

	// Getters
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public boolean getIsValidAge() {
		return isValidAge;
	}

	// Setters
	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		if (age >= 0) {
			this.isValidAge = true;
			this.age = age;
		} else {
			System.out.println("A idade tem que ser um valor positivo ou nulo");
		}
	}

}
