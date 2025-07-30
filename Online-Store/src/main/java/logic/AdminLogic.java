package logic;

import ui.UserInterface;

public class AdminLogic {

	static UserInterface ui = new UserInterface();

	public static void processAdminScreen() {
		boolean ifContinue = true;

		while(ifContinue) {
			int adminChoice = ui.displayAdminScreen();

			switch(adminChoice) {
				case 1 -> addProduct();
				case 2 -> updateProduct();
				case 3 -> deleteProduct();
				case 4 -> addCategory();
				case 5 -> deleteCategory();
				case 0 -> ifContinue = false;
			}
		}
	}

	private static void addProduct() {}

	private static void updateProduct() {}

	private static void deleteProduct() {}

	private static void addCategory() {}

	private static void deleteCategory() {}

}
