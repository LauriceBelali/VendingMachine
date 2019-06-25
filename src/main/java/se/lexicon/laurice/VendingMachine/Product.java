package se.lexicon.laurice.VendingMachine;

public abstract class Product {
	protected int num;
	protected String name;
	protected int price;

	public Product(int num, String name, int price) {
		super();
		this.num = num;
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getNum() {
		return num;
	}

	public abstract String examine();

	public abstract void use();

	public Product purchase(int money) {
		if (money >= price) {
			System.out.println("\n================ Product was successfully purchased ================\n");
			return this;
		}
		return null;
	}

}
