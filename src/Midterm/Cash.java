package Midterm;

import java.text.DecimalFormat;
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
	public String processingPayment(Scanner scan, double total) {
		double tender;
		double change;
		while (true) {
			tender = Validation.getDouble(scan, "Enter amount Tendered: ");
			change = tender - total;

			if (tender < total) {
				System.out.println("Not enough cash, please try again");
				System.out.println();
				continue;
			} else {
				break;
			}
		}
		return "\nPayment method Cash\nTotal: $" + new DecimalFormat("#.00").format(total) + "\nAmount tendered: $"
				+ new DecimalFormat("#.00").format(tender) + "\nChange:  $ " + new DecimalFormat("#.00").format(change);
	}

//	while(userInput>amount) {
//		return change;
//	}

}
