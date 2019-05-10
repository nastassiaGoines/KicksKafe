package Midterm;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

	List<Items> cart;
	double total;

	public ShoppingCart() {
		cart = new ArrayList<>();
	}
	
	public ShoppingCart(ArrayList<Items> cart) {
		this.cart = cart;
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

	public void addItem(String name, String category, String description, double price, int quantity) {
            cart.add(new Items(name, category, description, price, quantity));
            total= total+price;
        }

	public double removeItem(Items itemToRemove) {
		total = total - itemToRemove.getPrice();
		cart.remove(itemToRemove);
	return(total);

	}

	public List<Items> getCart() {
		return cart;
	}

	public void setCart(List<Items> cart) {
		this.cart = cart;
	}


	
	
}





