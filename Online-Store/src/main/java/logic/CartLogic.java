package logic;

import config.DatabaseConfig;
import data.CartDao;
import data.mysql.MySqlCartDao;
import models.Cart;
import models.CartItem;
import models.Printable;
import ui.UserInterface;
import utils.Utils;

import java.util.List;

public class CartLogic {

	static UserInterface ui = new UserInterface();
	static CartDao cartDao = new MySqlCartDao(DatabaseConfig.setConnection());

	public static void processCartScreen() {
		boolean ifContinue = true;

		while(ifContinue) {
			int userChoice = ui.displayCart();

			switch(userChoice) {
				case 1 -> displayCart();
				case 2 -> removeItem();
				case 3 -> checkout();
				case 0 -> ifContinue = false;
			}
		}
	}

	private static void displayCart() {
		List<CartItem> cartItems = cartDao.getCartItems();
		Cart cart = cartDao.getCart();

		printData(cartItems);
		System.out.println("_________________________");
		cart.print();

		Utils.pauseApp();
	}

	private static void removeItem() {

	}

	private static void checkout() {

	}

	private static void printData(List<CartItem> list) {
		if(list.isEmpty()) {
			System.out.println("There are no items in your cart...");
		} else {
			for(Printable item : list) {
				item.print();
			}
		}
	}

}
