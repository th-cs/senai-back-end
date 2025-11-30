// Read the name, price and discount percentage of a product. Return the price
// with discount applied
package ex02ProductPrice;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		double startingPrice;
		double discountPercentage;
		double difference;

		Scanner input = new Scanner(System.in);
		Product product = new Product();

		System.out.println("-- Cálculo de Desconto --\n");

		System.out.print("Olá, qual é o nome do produto? ");
		product.setName(input.nextLine());

		// Loops to read a valid input
		do {
			System.out.print("Qual é o preço desse produto? R$ ");
			startingPrice = input.nextDouble();
			product.setPrice(startingPrice);
		} while (!product.getIsValidPrice());

		do {
			System.out.print("E qual é o percentual de desconto? ");
			discountPercentage = input.nextDouble();
			product.applyDiscount(discountPercentage);
		} while (!product.getIsValidDiscount());

		System.out.println("Calculando o desconto do produto...");
		difference = startingPrice - product.getPrice();

		System.out.printf("\nProduto: %s\n"
			+ "Preço inicial: R$ %.2f\n"
			+ "Percentual de desconto: %.2f %%\n"
			+ "Preço com desconto: R$ %.2f\n"
			+ "Diferença: R$ %.2f\n", product.getName(), startingPrice,
			discountPercentage, product.getPrice(), difference);

		input.close();
	}

}
