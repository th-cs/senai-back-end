// Example of a bank account. It's possible to check the balance, deposit or
// withdraw
package ex01BankAccount;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int menuOption;
		boolean isMenuOpen;

		// Create an object "bankAccount" of type BankAccount with a balance
		// of R$ 0,00
		BankAccount bankAccount = new BankAccount(0);

		System.out.println("-- Conta Bancária --\n");
		System.out.print("Olá, o que você deseja fazer?");

		isMenuOpen = true;

		while (isMenuOpen) {
			System.out.println("\nEscolha uma das opções abaixo:\n"
				+ "| 1 | - Consultar o saldo da conta\n"
				+ "| 2 | - Realizar um depósito na conta\n"
				+ "| 3 | - Sacar um valor da conta\n"
				+ "| 0 | - Sair da conta");
			menuOption = input.nextInt();

			switch(menuOption) {
				case 1:
					System.out.printf("O saldo da sua conta é de R$ %.2f\n",
						bankAccount.getBalance());
					break;
				case 2:
					System.out.print("Digite o valor a ser depositado: R$ ");
					bankAccount.deposit(input.nextDouble());
					break;
				case 3:
					System.out.print("Digite o valor a ser sacado: R$ ");
					bankAccount.withdraw(input.nextDouble());
					break;
				case 0:
					System.out.println("Saindo da conta...");
					isMenuOpen = false;
					break;
				default:
					System.out.printf("%d não é uma opção aceita\n",
						menuOption);
					break;
			}
		}

		input.close();
	}
}
