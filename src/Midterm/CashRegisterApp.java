package Midterm;

import java.util.HashMap;
import java.util.Iterator;

public class CashRegisterApp {

	public static void main(String[] args) {
		// Load list of available item list for Operator's reference
		Items item = new Items();
//		  HashMap<String, Items> itemMap = item.getAllItems();

//		Iterator<String> iterator = itemMap.keySet().iterator();

		System.out.println("-----List of Available Items------[Item#, Description, Currency, Price]");

//		while (iterator.hasNext()) {
//		   Items item = itemMap.get(iterator.next()); 
//		   System.out.println(item.printStatus());
//		  }

			System.out.println("-------------------------------");

			ShoppingCart cart = new ShoppingCart();
//		  cart.start();
//		  cart.checkOut();

			System.out.println("Thank you for using POS, Have a nice day !!! ");
		}

	}

