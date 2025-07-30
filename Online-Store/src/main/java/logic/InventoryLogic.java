package logic;

import ui.UserInterface;

public class InventoryLogic {

	static UserInterface ui = new UserInterface();

	public static void processCartScreen() {
		boolean ifContinue = true;

		while(ifContinue) {
			int userChoice = ui.displayCart();


		}
	}
}
