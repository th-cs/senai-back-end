// Read a book's title, author and number of pages, then return the information.
// Books with fewer than 5 pages are not allowed
package ex01Book;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		Book book = new Book();

		System.out.println("-- Biblioteca Digital --\n");

		System.out.print("Olá, digite o título do livro: ");
		book.setTitle(input.nextLine());

		System.out.print("Digite o autor do livro: ");
		book.setAuthor(input.nextLine());

		do {
			System.out.print("Digite o número de páginas do livro: ");
			book.setNumberPages(input.nextInt());
		} while (!book.getIsValidNumberPages());

		System.out.printf("\nTítulo: %s\n"
			+ "Autor: %s\n"
			+ "Número de páginas: %d\n", book.getTitle(), book.getAuthor(),
			book.getNumberPages());

		input.close();

	}
}
