package Midterm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class CashRegisterApp {
	
	private static ShoppingCart cart = new ShoppingCart(readFromFile());

	public static void main(String[] args) {

		System.out.println("Kick's Kafe POS");
		System.out.println("---------------");
		System.out.println();
		menu();
		
		
		
		
		
		
		

		
		
	}
	public static void menu() {
		System.out.println("           Menu      ");
		System.out.printf("%-18s%-12s\n","Item","Price");
		System.out.println("````````````````````````");
		for (int i = 0; i < cart.getCart().size(); i++)
		System.out.printf("%-18s$%-12s\n",cart.getCart().get(i).getName(),cart.getCart().get(i).getPrice());
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
