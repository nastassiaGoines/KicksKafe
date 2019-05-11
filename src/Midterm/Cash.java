package Midterm;

import java.util.Scanner;

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
	
		
		return null;
		
	}
	
	public String processingPayment(Scanner scan, double total){
		double tender = Validation.getDouble(scan, "Enter amount Tendered");
		double change = tender - total;
	
		
		return "Payment method cash, Total" + total + "Amount tendered: $" + tender + "Change:  $ " + change;		
	}
	
	
	
	
	
	
//	while(userInput>amount) {
//		return change;
//	}
	

}
