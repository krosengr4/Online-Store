package logic;

import ui.UserInterface;

public class CartLogic {

	static UserInterface ui = new UserInterface();

	public static void processCartScreen() {
		boolean ifContinue = true;

		while(ifContinue) {
			int userChoice = ui.displayInventory();

			switch(userChoice) {
				case 1 -> displayCart();
				case 2 -> removeItem();
				case 3 -> checkout();
				case 0 -> ifContinue = false;
			}
		}
	}

	private static void displayCart() {

	}

	private static void removeItem() {

	}

	private static void checkout() {

	}

}
