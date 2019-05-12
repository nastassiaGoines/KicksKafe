package Midterm;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Credit extends Payment {
	
	private long creditNum;
	private String expirationDate;
	private String cvvNum;
	
	public long getCreditNum() {
		return creditNum;
	}
	public void setCreditNum(long creditNum) {
		this.creditNum = creditNum;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getCvvNum() {
		return cvvNum;
	}
	public void setCvvNum(String cvvNum) {
		this.cvvNum = cvvNum;
	}
	@Override
	public String processingPayment(Scanner scan, double total) {
		String ccNumber = Validation.getString(scan, "Enter Credit Card Number: ");
		String expDate = Validation.getString(scan, "Enter Expiration Date: ");
		String cvv = Validation.getString(scan, "Get cvv: ");
		return "\nCredit card Number: " + ccNumber + "\nExpiration Date" + expDate + "\ncvv: " + cvv + "\nAmount Charged: " + new DecimalFormat("#.00").format(total);
	}

	
	
}
