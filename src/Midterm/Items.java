package Midterm;

public class Items {
	private String name;
	private String category;
	private String description;
	private double price;
	private int quantity;
	
	public Items() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Items(String name, String category, String description, double price, int quantity) {
		super();
		this.name = name;
		this.category = category;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return name+":"+category+":"+description+":"+price+":"+quantity;
	}
	
	
	
	

}
