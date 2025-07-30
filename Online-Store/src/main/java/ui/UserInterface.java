package ui;

import utils.Utils;

public class UserInterface {

	public int displayHomePage() {
		System.out.println("\n\t---------HOME PAGE--------");
		System.out.println("""
					---OPTIONS---
				1 - Go to Inventory Screen
				2 - Go to Cart Screen
				0 - Exit
				""");

		return Utils.getUserInputIntMinMax("Enter Here:\n", 0, 2);
	}

	public int displayInventory() {
		System.out.println("\n\t\t--------INVENTORY--------");
		System.out.println("""
					---OPTION---
				1 - Display All Products
				2 - Display Products By Category
				3 - Search Product By Name
				4 - Add Product To Cart
				0 - Return Home
				""");

		return Utils.getUserInputIntMinMax("Enter Here:\n", 0, 4);
	}

	public int displayCategories() {
		System.out.println("\n\t\t--------CATEGORIES--------");
		System.out.println("""
					---OPTIONS---
				1 - Audio Video
				2 - Computers
				3 - Games
				4 - Electronics
				0 - Go back
				""");

		return Utils.getUserInputIntMinMax("Enter Here:\n", 0, 4);
	}

	public int displayCart() {
		System.out.println("\n\t\t--------YOUR CART--------");
		System.out.println("""
					---OPTIONS---
				1 - Display Your Cart
				2 - Remove Item from Cart
				3 - Checkout
				0 - Return Home
				""");

		return Utils.getUserInputIntMinMax("Enter Here:\n", 0, 3);
	}

}
