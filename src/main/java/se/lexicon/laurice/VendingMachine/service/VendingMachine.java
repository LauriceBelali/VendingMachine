package se.lexicon.laurice.VendingMachine.service;

import java.util.ArrayList;

import se.lexicon.laurice.VendingMachine.Product;

public interface VendingMachine {
	public void addMoney(int money);
	public Product buy(int productNum);
	public String returnChange();
	public void presentProducts();
	public int getBalance();
	public ArrayList<Product> getProductList();
}
