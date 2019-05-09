package Midterm;

public class Payment {

	private double cash;
	private long credit;
	private long check;
	
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payment(double cash, long credit, long check) {
		super();
		this.cash = cash;
		this.credit = credit;
		this.check = check;
	}

	public double getCash() {
		return cash;
	}

	public void setCash(double cash) {
		this.cash = cash;
	}

	public long getCredit() {
		return credit;
	}

	public void setCredit(long credit) {
		this.credit = credit;
	}

	public long getCheck() {
		return check;
	}

	public void setCheck(long check) {
		this.check = check;
	}

	@Override
	public String toString() {
		return cash+","+credit+","+check;
	}
	
	
	
	

}
