// This class describes the product's attributes and how to apply the discount
package ex02ProductPrice;

public class Product {

	// Attributes
	private String name;
	private double price;
	private boolean isValidPrice;
	private boolean isValidDiscount;

	// Getters
	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public boolean getIsValidPrice() {
		return isValidPrice;
	}

	public boolean getIsValidDiscount() {
		return isValidDiscount;
	}

	// Setters
	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		if (price >= 0) {
			this.isValidPrice = true;
			this.price = price;
		} else {
			System.out.println("O preço do produto deve ser um valor maior ou "
				+ "igual a 0");
		}
	}

	// Method
	public void applyDiscount(double discountPercentage) {
		if (discountPercentage >= 0 && discountPercentage <= 100) {
			this.isValidDiscount = true;
			this.price -= price * (discountPercentage / 100);
		} else {
			System.out.println("O desconto deve ser um valor entre 0% e 100%");
		}
	}

}
