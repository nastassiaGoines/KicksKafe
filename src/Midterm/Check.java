package Midterm;

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
		double checkNumber = Validation.getDouble(scan, "Enter check number");
		return "Check number" + checkNumber + "Total";
	}
	@Override
	public String processingPayment() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
