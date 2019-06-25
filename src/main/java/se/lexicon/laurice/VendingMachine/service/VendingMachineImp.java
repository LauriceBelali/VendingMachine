package se.lexicon.laurice.VendingMachine.service;

import java.util.ArrayList;

import se.lexicon.laurice.VendingMachine.Drink;
import se.lexicon.laurice.VendingMachine.Food;
import se.lexicon.laurice.VendingMachine.Product;
import se.lexicon.laurice.VendingMachine.Snack;

public class VendingMachineImp implements VendingMachine {


	private int[] denominations = { 1, 5, 10, 20, 50, 100, 500, 1000 };
	private ArrayList<Product> products;
	private int moneyPool;

	public VendingMachineImp() {
		super();
		Initialization();
	}

	private void Initialization() {
		this.products = InitializeProducts();
		this.moneyPool = 0;
	}

	private ArrayList<Product> InitializeProducts() {
		Product food = new Food(1, "Mixed nuts", 20, 136);
		Product snack = new Snack(2, "Pringles", 50, 1);
		Product drink = new Drink(3, "Coca cola", 100, 50);
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(food);
		products.add(snack);
		products.add(drink);
		return products;
	}

	@Override
	public void addMoney(int money) {
		boolean found = false;
		for (int i = 0; i < this.denominations.length; i++) {
			if (this.denominations[i] == money) {
				found = true;
			}
		}
		if (found) {
			System.out.println("The coin is inserted successfully !\n");
			this.moneyPool = this.moneyPool + money;
		} else {
			System.out.println("The coin is not in { 1, 5, 10, 20, 50, 100, 500, 1000 } !\n");
		}
	}

	@Override
	public Product buy(int productNum) {
		Boolean found = false;
		for (Product p : products) {
			if (p.getNum() == productNum) {
				found = true;
				if (p.purchase(this.moneyPool) != null) {
					this.products.remove(p);
					this.moneyPool = this.moneyPool - p.getPrice();

					return p;
				} else {
					System.out.println("\n=========== You don't have enough money in balance  ============\n");
				}
			}
		}
		if (!found) {
			System.out.println("\n=================== Product not found ! ========================\n");
		}
		return null;
	}

	@Override
	public String returnChange() {
		int p1000 = 0, p500 = 0, p100 = 0, p50 = 0, p20 = 0, p10 = 0, p5 = 0;
		while (this.moneyPool >= 1000) {
			p1000 = p1000 + 1;
			this.moneyPool = this.moneyPool - 1000;
		}
		while (this.moneyPool >= 500) {
			p500 = p500 + 1;
			this.moneyPool = this.moneyPool - 500;
		}
		while (this.moneyPool >= 100) {
			p100 = p100 + 1;
			this.moneyPool = this.moneyPool - 100;
		}
		while (this.moneyPool >= 50) {
			p50 = p50 + 1;
			this.moneyPool = this.moneyPool - 50;
		}
		while (this.moneyPool >= 20) {
			p20 = p20 + 1;
			this.moneyPool = this.moneyPool - 20;
		}
		while (this.moneyPool >= 10) {
			p10 = p10 + 1;
			this.moneyPool = this.moneyPool - 10;
		}
		while (this.moneyPool >= 5) {
			p5 = p5 + 1;
			this.moneyPool = this.moneyPool - 5;
		}

		int rest=this.moneyPool;
		this.moneyPool = 0;
		return "\n("+p1000+" X 1000kr), ("+p500+" X 500kr), ("+p100+" X 100kr), ("+p50+" X 50kr), ("+p20+" X 20kr), ("+p10+" X 10kr), ("+p5+" X 5kr) and "+rest+"kr !\n\n";
		
	}

	@Override
	public void presentProducts() {
		for (Product p : this.products) {
			System.out.println(p.examine());
		}
	}

	@Override
	public int getBalance() {
		return this.moneyPool;
	}
	
	@Override
	public ArrayList<Product> getProductList() {
		return this.products;
	}

}
