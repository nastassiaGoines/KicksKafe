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
		String ccNumber = Validation.getStringMatchingRegex(scan, "Enter Credit Card Number: ", "(\\d{4}[-. ]?){4}|\\d{4}[-. ]?\\d{6}[-. ]?\\d{5}");
		String expDate = Validation.getStringMatchingRegex(scan, "Enter Expiration Date (mm/yyyy): ", "^(0[1-9]|1[012])[- /.](19|20)\\d\\d$");
		String cvv = Validation.getStringMatchingRegex(scan, "Get cvv: ", "\\d\\d\\d");
		return "\nCredit card Number: " + ccNumber + "\nExpiration Date: " + expDate + "\ncvv: " + cvv + "\nAmount Charged: " + new DecimalFormat("#.00").format(total);
	}

	
	
}
