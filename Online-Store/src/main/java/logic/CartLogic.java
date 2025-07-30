package logic;

import config.DatabaseConfig;
import data.CartDao;
import data.ProductDao;
import data.mysql.MySqlCartDao;
import data.mysql.MySqlProductDao;
import models.Cart;
import models.CartItem;
import models.Printable;
import models.Product;
import ui.UserInterface;
import utils.Utils;

import java.util.List;

public class CartLogic {

	static UserInterface ui = new UserInterface();
	static CartDao cartDao = new MySqlCartDao(DatabaseConfig.setConnection());
	static ProductDao productDao = new MySqlProductDao(DatabaseConfig.setConnection());

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
		System.out.println("\n_______________________________________________");
		cart.print();

		Utils.pauseApp();
	}

	private static void removeItem() {
		int productId = Utils.getUserInputInt("Enter the Product ID to remove:\n");
		int userChoice = ui.displayRemoveItem();

		if(userChoice == 1) {
			cartDao.remove(productId);
		} else if(userChoice == 2) {
			decreaseQuantity(productId);
		}

		Utils.pauseApp();
	}

	private static void decreaseQuantity(int productId) {
		CartItem cartItem = cartDao.getItemByProductId(productId);

		int numberToRemove = Utils.getUserInputIntMinMax("How many would you like to remove?:\n", 1, (cartItem.getQuantity() - 1));

		int newQuantity = cartItem.getQuantity() - numberToRemove;
		cartItem.setQuantity(newQuantity);

		cartDao.update(productId, newQuantity);
	}

	private static void checkout() {
//		cartDao.clearCart();

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
