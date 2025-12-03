// Abstraction with different types of bank accounts
package ex01BankAccountAbstraction;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		int menuOption;
		boolean isMenuOpen;
		boolean isAccountOpen;
		String accountType = "";

		SavingsAccount savingsAccount = new SavingsAccount(0);
		CheckingAccount checkingAccount = new CheckingAccount(0);
		BusinessAccount businessAccount = new BusinessAccount(0);

		Scanner input = new Scanner(System.in);

		System.out.println("-- Conta Bancária --\n");
		System.out.println("Olá, o que você deseja fazer?");

		isMenuOpen = true;
		isAccountOpen = false;

		while (isMenuOpen) {
			System.out.println("\n- Informações para criar uma nova conta -");
			System.out.println("Olá, selecione o tipo de conta:\n"
				+ "| 1 | - Conta Poupança\n"
				+ "| 2 | - Conta Corrente\n"
				+ "| 3 | - Conta de Pessoa Jurídica\n"
				+ "| 0 | - Sair");
			menuOption = input.nextInt();

			switch (menuOption) {
				case 0:
					System.out.println("Saindo...");
					isMenuOpen = false;
					isAccountOpen = false;
					break;
				case 1:
					accountType = "SavingsAccount";

					input.nextLine();

					System.out.print("Digite o nome do titular da conta: ");
					savingsAccount.setAccountHolder(input.nextLine());

					System.out.print("Digite o número da conta: ");
					savingsAccount.setAccountNumber(input.nextInt());

					System.out.print("Digite o número da agência da conta: ");
					savingsAccount.setBranchNumber(input.nextInt());

					System.out.println("Conta Poupança criada!");

					isAccountOpen = true;
					break;
				case 2:
					accountType = "CheckingAccount";

					input.nextLine();

					System.out.print("Digite o nome do titular da conta: ");
					checkingAccount.setAccountHolder(input.nextLine());

					System.out.print("Digite o número da conta: ");
					checkingAccount.setAccountNumber(input.nextInt());

					System.out.print("Digite o número da agência da conta: ");
					checkingAccount.setBranchNumber(input.nextInt());

					System.out.println("Conta Corrente criada!");

					isAccountOpen = true;
					break;
				case 3:
					accountType = "BusinessAccount";

					input.nextLine();

					System.out.print("Digite o nome do titular da conta: ");
					businessAccount.setAccountHolder(input.nextLine());

					System.out.print("Digite o número da conta: ");
					businessAccount.setAccountNumber(input.nextInt());

					System.out.print("Digite o número da agência da conta: ");
					businessAccount.setBranchNumber(input.nextInt());

					System.out.println("Conta de Pessoa Jurídica criada!");

					isAccountOpen = true;
					break;
				default:
					System.out.printf("%d não é uma opção aceita\n",
						menuOption);
					break;
			}

			while(isAccountOpen) {
				System.out.println("\nEscolha uma das opções abaixo:\n"
					+ "| 1 | - Consultar o saldo da conta\n"
					+ "| 2 | - Realizar um depósito na conta\n"
					+ "| 3 | - Sacar um valor da conta\n"
					+ "| 4 | - Exibir a tarifa mensal\n"
					+ "| 0 | - Sair da conta");
				menuOption = input.nextInt();

				switch(menuOption) {
					case 0:
						System.out.println("Saindo da conta...");
						isAccountOpen = false;
						break;
					case 1:
						double balance;

						if (accountType.equals("SavingsAccount")) {
							balance = savingsAccount.getBalance();
						} else if (accountType.equals("CheckingAccount")) {
							balance = checkingAccount.getBalance();
						} else {
							balance = businessAccount.getBalance();
						}

						System.out.printf("O saldo da sua conta é de "
							+ "R$ %.2f\n", balance);
						break;
					case 2:
						double amount;

						System.out.print("Digite o valor a ser depositado: "
							+ "R$ ");
						amount = input.nextDouble();

						if (accountType.equals("SavingsAccount")) {
							savingsAccount.deposit(amount);
						} else if (accountType.equals("CheckingAccount")) {
							checkingAccount.deposit(amount);
						} else {
							businessAccount.deposit(amount);
						}
						break;
					case 3:
						System.out.print("Digite o valor a ser sacado: R$ ");
						amount = input.nextDouble();

						if (accountType.equals("SavingsAccount")) {
							savingsAccount.withdraw(amount);
						} else if (accountType.equals("CheckingAccount")) {
							checkingAccount.withdraw(amount);
						} else {
							businessAccount.withdraw(amount);
						}
						break;
					case 4:
						double monthlyFee;

						if (accountType.equals("SavingsAccount")) {
							monthlyFee = savingsAccount.calculateMonthlyFee();
						} else if (accountType.equals("CheckingAccount")) {
							monthlyFee = checkingAccount.calculateMonthlyFee();
						} else {
							monthlyFee = businessAccount.calculateMonthlyFee();
						}

						System.out.printf("A tarifa mensal da sua conta é "
							+ "R$ %.2f\n", monthlyFee);
						break;
					default:
						System.out.printf("%d não é uma opção aceita\n",
							menuOption);
						break;
				}
			}
		}

		input.close();
	}
}
