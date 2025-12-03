// This class describes the attributes of a checking account
package ex01BankAccountAbstraction;

public class CheckingAccount extends Account {

	// Attribute
	private double monthlyFee;

	// Constructor
	public CheckingAccount(double balance) {
		super(balance);
	}

	// Method
	@Override
	public double calculateMonthlyFee() {
		this.monthlyFee = 12.00;
		return monthlyFee;
	}
}
