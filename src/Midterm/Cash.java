package Midterm;

public class Cash extends Payment {

	private double change;
	private double amount;
	
	public double getChange() {
		return change;
	}
	public void setChange(double change) {
		this.change = change;
	}

	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public String processingPayment() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
//	while(userInput>amount) {
//		return change;
//	}
	

}
