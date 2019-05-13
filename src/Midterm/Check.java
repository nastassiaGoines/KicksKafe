package Midterm;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Check extends Payment {
	
	private boolean id;
	private String name;
	private long checkNum;
	
	
	public boolean isId() {
		return id;
	}
	public void setId(boolean id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getCheckNum() {
		return checkNum;
	}
	public void setCheckNum(long checkNum) {
		this.checkNum = checkNum;
	}
	@Override
	public String processingPayment(Scanner scan, double total) {
		String checkNumber = Validation.getStringMatchingRegex(scan, "Enter check number", "\\d{6}");
		return "\nCheck number: " + checkNumber + "\nCheck Amount: " + new DecimalFormat("#.00").format(total);
	}

	

}
