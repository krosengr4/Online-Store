package logic;

import config.DatabaseConfig;
import data.CartDao;
import data.OrderDao;
import data.ProductDao;
import data.mysql.MySqlCartDao;
import data.mysql.MySqlOrderDao;
import data.mysql.MySqlProductDao;
import models.*;
import org.apache.commons.dbcp2.BasicDataSource;
import ui.UserInterface;
import utils.Utils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class CartLogic {

	static UserInterface ui = new UserInterface();

	static BasicDataSource dataSource = DatabaseConfig.setConnection();
	static CartDao cartDao = new MySqlCartDao(dataSource);
	static ProductDao productDao = new MySqlProductDao(dataSource);
	static OrderDao orderDao = new MySqlOrderDao(dataSource);

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
		String customerName = Utils.getUserInput("Please your name for the order:\n");

		Utils.getUserInput("Enter your card number:\n");
		Utils.getUserInput("Enter the expiration date:\n");
		Utils.getUserInput("Enter the 3 digit CVV:\n");

		String userAddress = Utils.getUserInput("Enter your address:\n");
		String userCity = Utils.getUserInput("Enter your city:\n");
		String userState = Utils.getUserInput("Enter your state:\n");

		Order order = new Order(0, LocalDateTime.now(), customerName, userAddress, userCity, userState);
		Order addedOrder = orderDao.add(order);

		addLineItems(addedOrder);

		System.out.println("Thank you for your purchase!\nYou will be sent an email of the purchase details shortly!");
		cartDao.clearCart();
		Utils.pauseApp();
	}

	private static void addLineItems(Order order) {
		int orderId = order.getOrderId();
		List<CartItem> cartItems = cartDao.getCartItems();

		for(CartItem item : cartItems) {
			OrderLineItems lineItem = new OrderLineItems(0, order.getOrderId(), item.getProductId(), item.getQuantity(), BigDecimal.valueOf(item.getPrice()));
			orderDao.addLineItem(lineItem);
		}
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
