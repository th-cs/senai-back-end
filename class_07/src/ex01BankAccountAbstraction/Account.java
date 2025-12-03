// This class describes how the account works and the methods that other
// classes must implement or override
package ex01BankAccountAbstraction;

abstract class Account {

	// Attributes
	private int accountNumber;
	private int branchNumber;
	private String accountHolder;
	private double balance;

	// Constructos
	public Account(double balance) {
		this.balance = balance;
	}

	// Getter
	public double getBalance() {
		return balance;
	}

	// Setters
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setBranchNumber(int branchNumber) {
		this.branchNumber = branchNumber;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	public void setBalance(double balance) {
		this.balance = balance;
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

	// Abstract method
	abstract double calculateMonthlyFee();

}
