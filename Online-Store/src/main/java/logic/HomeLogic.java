package logic;

import ui.UserInterface;
import utils.Utils;

public class HomeLogic {

	static UserInterface ui = new UserInterface();

	public static void processHomeScreen() {
		boolean ifContinue = true;

		while(ifContinue) {
			int userChoice = ui.displayHomePage();

			switch(userChoice) {
				case 1 -> InventoryLogic.processInventoryScreen();
				case 2 -> CartLogic.processCartScreen();
				case 3 -> processAdmin();
				case 0 -> ifContinue = false;
			}
		}
	}

	private static void processAdmin() {
		String userPassword = Utils.getUserInput("Enter the password:\n");
		boolean passwordCheck = Utils.passwordCheck(userPassword);

		if(passwordCheck) {
			AdminLogic.processAdminScreen();
		} else {
			System.err.println("That password is incorrect!");
		}
	}
}
