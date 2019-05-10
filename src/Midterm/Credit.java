package Midterm;

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
	public String processingPayment() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
