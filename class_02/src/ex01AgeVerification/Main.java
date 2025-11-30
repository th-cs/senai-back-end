// Read a person's name and age. Then check if the age is a valid value and
// return the information
package ex01AgeVerification;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		Person person = new Person();

		System.out.println("-- Verificação de Idade --\n");

		System.out.print("Olá, qual é o seu nome? ");
		person.setName(input.nextLine());

		// Loop to read a valid input
		do {
			System.out.print("E qual é a sua idade? ");
			person.setAge(input.nextInt());
		} while(!person.getIsValidAge());

		System.out.printf("Você se chama %s e tem %d ano(s)\n",
			person.getName(), person.getAge());

		input.close();
	}
}
