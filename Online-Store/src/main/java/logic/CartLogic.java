package logic;

import config.DatabaseConfig;
import data.CartDao;
import data.mysql.MySqlCartDao;
import models.Cart;
import models.CartItem;
import ui.UserInterface;

import java.util.List;

public class CartLogic {

	static UserInterface ui = new UserInterface();
	static CartDao cartDao = new MySqlCartDao(DatabaseConfig.setConnection());

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
