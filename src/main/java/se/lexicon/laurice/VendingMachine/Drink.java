package se.lexicon.laurice.VendingMachine;

public class Drink extends Product {

	private int volume;

	public Drink(int num, String name, int price, int volume) {
		super(num, name, price);
		this.volume = volume;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	@Override
	public String examine() {
		return "[" + this.num + "]. [" + this.name + "] , Price : " + this.price + "kr , Volume : " + this.volume;
	}

	@Override
	public void use() {
		System.out.println("Drink this product");
	}

}
