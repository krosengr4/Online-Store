package models;

import java.util.HashMap;
import java.util.Map;

public class Cart implements Printable{

	private Map<Integer, CartItem> items = new HashMap<>();

	public Map<Integer, CartItem> getItems() {
		return items;
	}

	public void setItems(Map<Integer, CartItem> items) {
		this.items = items;
	}

	public boolean contains(int productId) {
		return items.containsKey(productId);
	}

	public void add(CartItem item) {
		items.put(item.getProductId(), item);
	}

	public double getTotal() {
		double price = 0;

		for(CartItem item : items.values()) {
			Product product = item.getProduct();
			price += (product.getPrice() * item.getQuantity());
		}

		return price;
	}

	@Override
	public void print() {
		System.out.println("\t-----YOUR CART-----");
		System.out.println("-----------------------------------------------");

		System.out.println("Total Items: " + items.size());
		System.out.println("Total Price: $" + this.getTotal());
		System.out.println("-----------------------------------------------");
	}

}
