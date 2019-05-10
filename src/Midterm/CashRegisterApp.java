package Midterm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;


public class CashRegisterApp {
	
	private static ShoppingCart cart = new ShoppingCart(readFromFile());

	public static void main(String[] args) {

		System.out.println("Kick's Kafe POS");
		System.out.println("---------------");
		System.out.println();
		menu();
		
		
		System.out.println("");
		do {
			System.out.println("What item would you like to order?");
			Scanner scan = new Scanner(System.in);
		int userSelect = scan.nextInt();
		String userCont;
		
		if (userSelect == 1) {
			//put cap in cart
			System.out.println("");
		}else if (userSelect == 2) {
			//put coffee in cart 
		}else if (userSelect == 3) {
			//put oj in 
		}else if (userSelect == 4) {
			//put aj in cart 
		}else if (userSelect == 5) {
			//put smoothie
		}else if (userSelect == 6) {
			//put bagel
		}else if (userSelect == 7) {
			//donut 
		}else if (userSelect == 8) {
			//croissant 
		}else if (userSelect == 9) {
			//bfast sandy
		}else if (userSelect == 10) {
			//sneakers
		}else if (userSelect == 11) {
			//t shirt
		}else if (userSelect == 12) {
			//pants
		}else if (userSelect == 13) {
			//sweatshirt
		}else {
			System.out.println("Please enter a valid menu number.");
		}while (userCont.equalsIgnoreCase("y"));
		
		System.out.println("Thanks for your order!");
		System.out.println("Heres what you got:");
		
			
		
		
		
		
		

		
		
	}
	public static void menu() {
		System.out.println("           Menu      ");
		System.out.printf("%-18s%-12s\n","Item","Price");
		System.out.println("````````````````````````");
		for (int i = 0; i < cart.getCart().size(); i++)
		System.out.printf(i+1 + " " + "%-18s$%-12s\n",cart.getCart().get(i).getName(),cart.getCart().get(i).getPrice());
	}
	
	
	

	public static ArrayList<Items> readFromFile() {
		ArrayList<Items> menu = new ArrayList<>();
		String file = "src/Midterm/menu.txt";
		Path filePath = Paths.get(file);

		File f = filePath.toFile();
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(f));
			String line = br.readLine();
			String[] item;

			while (line != null) {
				item = line.split(":", 0);
				line = br.readLine();
				Items sLine = new Items(item[2], item[1], item[3], Double.parseDouble(item[0]), 0);
				menu.add(sLine);
			}
			br.close();

		} catch (FileNotFoundException e) {
			System.out.println("The file was not found");
		} catch (IOException e) {
			System.out.println("IO error");
		}
		return menu;
	}
	
	
}
