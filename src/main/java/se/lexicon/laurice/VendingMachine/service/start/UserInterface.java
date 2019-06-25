package se.lexicon.laurice.VendingMachine.service.start;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Scanner;
import se.lexicon.laurice.VendingMachine.Product;
import se.lexicon.laurice.VendingMachine.service.VendingMachine;
import se.lexicon.laurice.VendingMachine.service.VendingMachineImp;

public class UserInterface {

	private static VendingMachine vendingMachine;
	private static Scanner scanner = new Scanner(System.in);

	
	public static void main(String[] args) throws IOException {
		vendingMachine = new VendingMachineImp();
		String choice = startMenu();
		ArrayList<Product> cart = new ArrayList<Product>();
		while (!choice.equals("E")) {
			switch (choice) {
			case "A":
				System.out.println("==================== Please insert Coin : ======================");
				vendingMachine.addMoney(scanner.nextInt());
				choice = startMenu();
				break;
			case "B":
				System.out.println("=========================== Balance : ==========================");
				System.out.println("\n" + vendingMachine.getBalance() + "kr\n");
				choice = startMenu();
				break;
			case "C":
				if (!cart.isEmpty()) {
					System.out.println("\n========================= My Products : ========================");
					for (Product product : cart) {
						System.out.println(product.examine());
						product.use();
					}
				} else {
					System.out.println("\n======================== No Products ! =========================\n");
				}
				choice = startMenu();
				break;
			case "D":
				System.out.println("=========================== Change : ===========================");
				System.out.println(vendingMachine.returnChange());
				choice = startMenu();
				break;
			default:
				Product p=vendingMachine.buy(Integer.parseInt(choice));
				if (p != null) {
					cart.add(p);
				}
				choice = startMenu();
				break;
			}
		}
		System.out.println("Good Bye !");
	}

	public static String startMenu() {

		String choice = "E";
		System.out.println("================================================================");
		System.out.println("================= Please enter your selection: =================");
		System.out.println("================================================================");
		System.out.println("[A]. Insert coin ");
		System.out.println("[B]. Balance ");
		System.out.println("[C]. My products ");
		System.out.println("[D]. Return change ");
		System.out.println("[E]. Exit");
		System.out.println("================================================================");
		System.out.println("====================== Or select an item: ======================");
		System.out.println("================================================================");
		vendingMachine.presentProducts();
		if (scanner.hasNext()) {
			choice = scanner.next();
		}
		return choice.toUpperCase();
	}

	}
