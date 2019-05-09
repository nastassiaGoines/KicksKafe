package Midterm;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart  {

	List<String> cart;
	double total;

	public ShoppingCart() {
		cart = new ArrayList<String>();
	}

	public void addcart(String item) {
		cart.add(item);
	}

	public void removecart(String item) {
		cart.remove(item);
	}

	public void getNumberOfcart() {
		System.out.println(cart.size());
	}

	public String getItemName(int index) {
		return cart.get(index);
	}

public void getTotalOfCart(){
    total = 0;
    for(String x: cart){
        if (x.equals())){
            total =;
        }else if (x.equals()){
            total =;
        }else if (x.equals()){
            total =;
        }
    }
    System.out.println(total);
}
