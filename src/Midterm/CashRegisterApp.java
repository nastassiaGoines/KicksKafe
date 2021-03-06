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
			System.out.println();
			System.out.println("Welcome to Kicks Kafe!!");
			int menuChoice = Validation.getInt(scan,
					"\n1.Beverages \n2.Snacks \n3.Apparel\n\nEnter 1-3 for menu (0 for Cart, -1 to Checkout): ", -1, 3);
			int userSelect = 0;

			if (menuChoice == 1) {
				beverageMenu();
				userSelect = Validation.getInt(scan, "What item would you like to order?: ", -1, 5);
			} else if (menuChoice == 2) {
				snackMenu();
				userSelect = Validation.getInt(scan, "What item would you like to order?: ", 6, 9);
			} else if (menuChoice == 3) {
				apparelMenu();
				userSelect = Validation.getInt(scan, "What item would you like to order?: ", 10, 13);
			} else if (menuChoice == 0) {
				viewCart();
				continue;
			} else if (menuChoice == -1) {
				int goInt = Validation.getGo(scan, "Are you sure you want to checkout? (y/n): ");
				if (goInt == 1) {
					receipt(scan);
					goInt = Validation.getGo(scan, "Would you like to keep shopping? (y/n): ");
					if (goInt == 1) {
						continue;
					} else if (goInt == 2) {
						goInt = Validation.getGo(scan, "Are you sure you want to quit? (y/n): ");
						if (goInt == 1) {
							break;
						} else if (goInt == 2) {
							System.out.println("Geez... Just asking...");
							continue;
						}
					}
				} else {
					continue;
				}
			}
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
			}
		}

		System.out.println();
		System.out.println("Thanks for visiting KicksKafe!");
		System.out.println("Goodbye!");

		scan.close();

	}

	public static void beverageMenu() {
		System.out.println("Menu");
		System.out.println("-------------");
		System.out.println();
		System.out.println("           Beverage Menu      ");
		System.out.printf("#  %-18s%-12s\n", "Item", "Price");
		System.out.println("```````````````````````````");
		for (int i = 0; i < 5; i++)
			System.out.printf("%-3s%-18s$%-12s\n", i + 1, cart.get(i).getName(), cart.get(i).getPrice());
		System.out.println();
	}

	public static void snackMenu() {
		System.out.println("Menu");
		System.out.println("-------------");
		System.out.println();
		System.out.println("           Snacks Menu      ");
		System.out.printf("#  %-18s%-12s\n", "Item", "Price");
		System.out.println("```````````````````````````");
		for (int i = 5; i < 9; i++)
			System.out.printf("%-3s%-18s$%-12s\n", i + 1, cart.get(i).getName(), cart.get(i).getPrice());
		System.out.println();
	}

	public static void apparelMenu() {
		System.out.println("Menu");
		System.out.println("-------------");
		System.out.println();
		System.out.println("           Apparel Menu      ");
		System.out.printf("#  %-18s%-12s\n", "Item", "Price");
		System.out.println("```````````````````````````");
		for (int i = 9; i < cart.size(); i++)
			System.out.printf("%-3s%-18s$%-12s\n", i + 1, cart.get(i).getName(), cart.get(i).getPrice());
		System.out.println();
	}

	public static void viewCart() {
		double subTotal = 0;
		int counter = 1;
		System.out.println();
		System.out.println("           Cart      ");
		System.out.printf("#  %-18s %-12s%-12s %-12s\n", "Item", "Price", "Quantity", "Line Total");
		System.out.println("```````````````````````````````````````````````````````````````");
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getQuantity() != 0) {
				System.out.printf("%-3s%-18s$%-12s%-12s$%-12s\n", counter, cart.get(i).getName(),
						cart.get(i).getPrice(), cart.get(i).getQuantity(),
						new DecimalFormat("#.00").format((cart.get(i).getPrice() * cart.get(i).getQuantity())));
				subTotal += (cart.get(i).getPrice() * cart.get(i).getQuantity());
				counter += 1;
			}
		}
		System.out.println("_______________________________________________________________");
		System.out.printf("   %-43s$%s", "Subtotal", new DecimalFormat("#.00").format(subTotal));
		System.out.println();
		System.out.println();
	}

	public static void viewLine(int i) {
		System.out.println();
		System.out.printf("%-18s%-18s %-12s%-24s\n", "Item", "Category", "Price", "Description");
		System.out.println("`````````````````````````````````````````````````````````````````");
		System.out.printf("%-18s%-18s$%-12s%-24s\n", cart.get(i - 1).getName(), cart.get(i - 1).getCategory(),
				cart.get(i - 1).getPrice(), cart.get(i - 1).getDescription());
		System.out.println();
	}

	public static void lineTotal(int i, int quantity) {
		System.out.println();
		System.out.printf("%-18s %-18s%-12s %-12s\n", "Item", "Price", "Quantity", "Subtotal");
		System.out.println("`````````````````````````````````````````````````````````````````");
		System.out.printf("%-18s$%-18s%-12s$%-12s\n", cart.get(i - 1).getName(), cart.get(i - 1).getPrice(), quantity,
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

	public static void receipt(Scanner scan) {
		int checkCart = 0;
		for (int i = 0; i < cart.size(); i++) {
			checkCart += cart.get(i).getQuantity();
		}
		if (checkCart == 0) {
			System.out.println("Cart is empty, can't checkout!");
		} else {

			double subTotal = 0;
			int counter = 1;
			System.out.println();
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
					System.out.println();
					System.out.println("Thanks for visiting KicksKafe!");

				}
			}
			double salesTax = (subTotal * 1.06) - subTotal;
			double total = subTotal + salesTax;
			System.out.println("_______________________________________________________________");
			System.out.printf("  %-43s$%s", "Subtotal", new DecimalFormat("#.00").format(subTotal));
			System.out.printf("\n  %-43s$%s", "Sales Tax", new DecimalFormat("#.00").format(salesTax));
			System.out.printf("\n  %-43s$%s", "Total", new DecimalFormat("#.00").format(total));
			System.out.println();
			System.out.println();
			// details from user choice of payment
			// card num, check num, or change

			Payment pay = null;
			int userPay = Validation.getInt(scan, "Enter 1 for Cash, 2 for Check, or 3 for Credit: ", 1, 3);

			if (userPay == 1) {
				pay = new Cash();
				System.out.println(pay.processingPayment(scan, total));
			} else if (userPay == 2) {
				pay = new Check();
				System.out.println(pay.processingPayment(scan, total));
			} else if (userPay == 3) {
				pay = new Credit();
				System.out.println(pay.processingPayment(scan, total));
			}
		}
	}
}
