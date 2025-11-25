// This class describes how the bank account work
package ex01BankAccount;

public class BankAccount {
	// Attribute
	private double balance;

	// Constructor
	public BankAccount(double balance) {
		this.balance = balance;
	}

	// Getter
	public double getBalance() {
		return balance;
	}

	// Methods
	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
			System.out.println("Depósito realizado!");
		} else if (amount == 0) {
			System.out.println("Você não pode depositar um valor nulo");
		} else {
			System.out.println("Valor digitado não aceito");
		}
	}

	public void withdraw(double amount) {
		if (balance >= amount && amount > 0) {
			balance -= amount;
			System.out.println("Saque realizado!");
		} else if (balance < amount) {
			System.out.println("Saldo insuficiente para realizar a operação");
		} else if (amount == 0) {
			System.out.println("Você não pode sacar um valor nulo");
		} else {
			System.out.println("Valor digitado não aceito");
		}
	}
}
