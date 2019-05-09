package Midterm;

public class Beverages extends Items {
	public void Cap(String name, String description, double price) {
		name = "Cappuccino";
		description = "Classic Cap.";
		price = 3.95;
	}

	public void Coffee(String name, String description, double price) {
		name = "Coffee";
		description = "Comes black, with room for you to fix it just the way you like.";
		price = 1.95;
	}

	public void OJ(String name, String description, double price) {
		name = "Orange Juice";
		description = "Fresh Florida flavor.";
		price = 2.95;
	}

	public void AJ(String name, String description, double price) {
		name = "Apple Juice";
		description = "Fresh from the orchard.";
		price = 2.95;
	}
	public void Smoothie(String name, String description, double price) {
		name = "Smoothie";
		description = "Blended to perfection from a daily mix of fruits.";
		price = 5.95;
	}
}
