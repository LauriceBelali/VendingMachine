package se.lexicon.laurice.VendingMachine;

public class Snack extends Product {
	private int sugarPercent;

	public Snack(int num, String name, int price, int sugarPercent) {
		super(num, name, price);
		this.sugarPercent = sugarPercent;
	}

	@Override
	public String examine() {
		return "[" + this.num + "]. [" + this.name + "] , Price : " + this.price + "kr , Sugar percent : "
				+ this.sugarPercent + "%";
	}

	@Override
	public void use() {
		System.out.println("Eat this product");
	}


}
