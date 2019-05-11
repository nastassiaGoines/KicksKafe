package Midterm;

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
		String ccNumber = Validation.getString(scan, "Enter Credit Card Number");
		String expDate = Validation.getString(scan, "Get expiration date");
		String cvv = Validation.getString(scan, "Get cvv");
		return "Credit card Number" + ccNumber + "expiration date" + expDate + "cvv" + cvv + "Total" + total;
	}
	@Override
	public String processingPayment() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
