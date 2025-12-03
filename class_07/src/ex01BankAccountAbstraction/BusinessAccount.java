// This class describes the attributes of a business account
package ex01BankAccountAbstraction;

public class BusinessAccount extends Account {

	// Attribute
	private double monthlyFee;

	// Constructor
	public BusinessAccount(double balance) {
		super(balance);
	}

	// Methods
	@Override
	public double calculateMonthlyFee() {
		this.monthlyFee = 20.00;
		return monthlyFee;
	}

	@Override
	public void withdraw(double amount) {
		if (super.getBalance() >= amount + 1.50 && amount > 0) {
			super.setBalance(super.getBalance() - (amount + 1.50));
			System.out.println("Saque realizado! Foi descontada uma taxa de R$ "
				+ "1,50 da sua conta");
		} else if (super.getBalance() < amount + 1.50) {
			System.out.println("Saldo insuficiente para realizar a operação");
		} else if (amount == 0) {
			System.out.println("Você não pode sacar um valor nulo");
		} else {
			System.out.println("Valor digitado não aceito");
		}
	}

}
