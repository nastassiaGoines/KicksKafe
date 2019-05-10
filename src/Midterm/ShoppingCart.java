package Midterm;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

	List<Items> cart;
	double total;

	public ShoppingCart() {
		cart = new ArrayList<>();
	}

	public void addcart(Items item) {
		cart.add(item);
	}

	public void removecart(Items item ) {
		cart.remove(item);
	}

	public void getNumberOfcart(Items item) {
		System.out.println(cart.size());
	}

	public Items getItemName(int index) {
		return cart.get(index);
	}

	public void addItem(String name, String description, double price) {
            cart.add(new Items(name, description, price));
            total= total+price;
        }

	public double removeItem(Items itemToRemove) {
		total = total - itemToRemove.getPrice();
		cart.remove(itemToRemove);
	return(total);

	}
}





