package Midterm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class CashRegisterApp {

	private static ArrayList<Items> cart = readFromFile();

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		while (true) {

			/*
			 * TODO We need to add item categories, maybe have 3 sub-menus for categories
			 * 
			 * Need to do payment method
			 * 
			 * Need receipt method after purchase
			 */

			menu();
			int userSelect = Validation.getInt(scan,
					"What item would you like to order?\n(0 to view cart, -1 to quit): ", -1, 13);
			int userQuant = 0;

			if (userSelect >= 1) {
				viewLine(userSelect);
				// ask for quant
				userQuant = Validation.getInt(scan, "How many would you like? (0 to cancel): ", 0, 100);
				if (userQuant == 0) {
					System.out.println("Sale cancelled!");
					continue;
				}
				// ask to add
				lineTotal(userSelect, userQuant);
				add(userSelect, userQuant, scan);
				int goInt = Validation.getGo(scan, "Would you like to keep shopping? (y/n): ");
				if (goInt == 1) {
					continue;
				} else if (goInt == 2) {
					goInt = Validation.getGo(scan, "Are you sure you want to check out? (y/n): ");
					if (goInt == 1) {
						break;
					} else {
						continue;
					}
				}
			} else if (userSelect == -1) {
				int goInt = Validation.getGo(scan, "Are you sure you want to quit? (y/n): ");
				if (goInt == 1) {
					break;
				} else if (goInt == 2) {
					System.out.println("Geez... Just asking...");
					continue;
				}
			} else if (userSelect == 0) {
				viewCart();
			}

			//CHECKOUT
			
			//payment(scan);
			
			System.out.println("Thanks for your order!");
			System.out.println("Heres what you got:");

			receipt();

		}

		System.out.println();
		System.out.println("Thanks for visiting KicksKafe!");
		System.out.println("Goodbye!");
		
		scan.close();

	}

	public static void menu() {
		System.out.println("KicksKafe POS");
		System.out.println("-------------");
		System.out.println();
		System.out.println("           Menu      ");
		System.out.printf("# %-18s%-12s\n", "Item", "Price");
		System.out.println("````````````````````````");
		for (int i = 0; i < cart.size(); i++)
			System.out.printf(i + 1 + " " + "%-18s$%-12s\n", cart.get(i).getName(), cart.get(i).getPrice());
		System.out.println();
	}

	public static void viewCart() {
		double subTotal = 0;
		int counter = 1;
		System.out.println("           Cart      ");
		System.out.printf("# %-18s%-12s%-12s%-12s\n", "Item", "Price", "Quantity", "Line Total");
		System.out.println("```````````````````````````````````````````````````````````````");
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getQuantity() != 0) {
				System.out.printf(counter + " " + "%-18s$%-12s%-12s$%-12s\n", cart.get(i).getName(),
						cart.get(i).getPrice(), cart.get(i).getQuantity(),
						new DecimalFormat("#.00").format((cart.get(i).getPrice() * cart.get(i).getQuantity())));
				subTotal += (cart.get(i).getPrice() * cart.get(i).getQuantity());
				counter += 1;
			}
		}
		System.out.println("_______________________________________________________________");
		System.out.printf("  %-45s$%s", "Subtotal", new DecimalFormat("#.00").format(subTotal));
		System.out.println();
		System.out.println();
	}

	public static void viewLine(int i) {
		System.out.println();
		System.out.printf("%-18s%-12s%-24s\n", "Item", "Price", "Description");
		System.out.println("`````````````````````````````````````````");
		System.out.printf("%-18s$%-12s%-24s\n", cart.get(i - 1).getName(), cart.get(i - 1).getPrice(),
				cart.get(i - 1).getDescription());
		System.out.println();
	}

	public static void lineTotal(int i, int quantity) {
		System.out.println();
		System.out.printf("%-18s%-12s%-12s$%-12s\n", "Item", "Price", "Quantity", "Subtotal");
		System.out.println("`````````````````````````````````````````");
		System.out.printf("%-18s$%-12s%-12s$%-12s\n", cart.get(i - 1).getName(), cart.get(i - 1).getPrice(), quantity,
				new DecimalFormat("#.00").format(cart.get(i - 1).getPrice() * quantity));
		System.out.println();
	}

	public static void add(int i, int quantity, Scanner scan) {
		int buy = Validation.getGo(scan, "Add item to cart? (y/n): ");
		if (buy == 1) {
			cart.get(i - 1).setQuantity(cart.get(i - 1).getQuantity() + quantity);
			System.out.println("Added to cart!");
			System.out.println();
		} else if (buy == 2) {
			System.out.println("Sale cancelled!");
			System.out.println();
		}
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

	public static void receipt() {
		double subTotal = 0;
		int counter = 1;
		System.out.println("           Items Purchased      ");
		System.out.printf("# %-18s%-12s%-12s%-12s\n", "Item", "Price", "Quantity", "Line Total");
		System.out.println("```````````````````````````````````````````````````````````````");
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getQuantity() != 0) {
				System.out.printf(counter + " " + "%-18s$%-12s%-12s$%-12s\n", cart.get(i).getName(),
						cart.get(i).getPrice(), cart.get(i).getQuantity(),
						new DecimalFormat("#.00").format((cart.get(i).getPrice() * cart.get(i).getQuantity())));
				subTotal += (cart.get(i).getPrice() * cart.get(i).getQuantity());
				counter += 1;
			}
		}
		System.out.println("_______________________________________________________________");
		System.out.printf("  %-45s$%s", "Subtotal", new DecimalFormat("#.00").format(subTotal));
		System.out.println();
		System.out.println();
	    
		
	}
}
