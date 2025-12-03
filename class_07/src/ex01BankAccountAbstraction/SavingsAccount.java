// This class describes the attributes of a savings account
package ex01BankAccountAbstraction;

public class SavingsAccount extends Account {

	// Attribute
	private double monthlyFee;

	// Constructor
	public SavingsAccount(double balance) {
		super(balance);
	}

	// Method
	@Override
	public double calculateMonthlyFee() {
		this.monthlyFee = 0.00;
		return monthlyFee;
	}
}
