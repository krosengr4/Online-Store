package logic;

import ui.UserInterface;

public class HomeLogic {

	static UserInterface ui = new UserInterface();

	public static void processHomeScreen() {
		boolean ifContinue = true;

		while(ifContinue) {
			int userChoice = ui.displayHomePage();

			switch(userChoice) {
				case 1 -> InventoryLogic.processInventoryScreen();
				case 2 -> CartLogic.processCartScreen();
				case 0 -> ifContinue = false;
			}
		}
	}
}
