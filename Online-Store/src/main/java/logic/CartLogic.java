package logic;

import ui.UserInterface;

public class CartLogic {

	static UserInterface ui = new UserInterface();

	public static void processInventoryScreen() {
		boolean ifContinue = true;

		while(ifContinue) {
			int userChoice = ui.displayInventory();

		}
	}

}
