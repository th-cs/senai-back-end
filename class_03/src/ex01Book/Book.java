// This class describes the book's attributes
package ex01Book;

public class Book {

	// Attributes
	private String title;
	private String author;
	private int numberPages;
	private boolean isValidNumberPages;

	// Getters
	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public int getNumberPages() {
		return numberPages;
	}

	public boolean getIsValidNumberPages() {
		return isValidNumberPages;
	}

	// Setters
	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setNumberPages(int numberPages) {
		if (numberPages >= 5) {
			this.isValidNumberPages = true;
			this.numberPages = numberPages;
		} else if (numberPages <= 0) {
			System.out.println("Valor não aceito");
		} else {
			System.out.println("O livro deve ter pelo menos 5 páginas");
		}
	}
}
