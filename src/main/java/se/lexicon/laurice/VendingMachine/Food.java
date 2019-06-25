package se.lexicon.laurice.VendingMachine;

public class Food extends Product {
	private int calories;

	public Food(int num, String name, int price, int calories) {
		super(num, name, price);
		this.calories = calories;
	}

	@Override
	public String examine() {
		return "[" + this.num + "]. [" + this.name + "] , Price : " + this.price + "kr , Calories : " + this.calories;
	}

	@Override
	public void use() {
		System.out.println("Eat this product");
	}
}
