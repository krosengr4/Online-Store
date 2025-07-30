package logic;

import ui.UserInterface;

public class InventoryLogic {

	static UserInterface ui = new UserInterface();

	public static void processInventoryScreen() {
		boolean ifContinue = true;

		while(ifContinue) {
			int userChoice = ui.displayCart();

			switch(userChoice) {
				case 1 -> displayAll();
				case 2 -> displayByCategory();
				case 3 -> searchByName();
				case 0 -> ifContinue = false;
			}
		}
	}

	private static void displayAll() {

	}

	private static void displayByCategory() {

	}

	private static void searchByName() {

	}

	private static void addToCart() {

	}
}
