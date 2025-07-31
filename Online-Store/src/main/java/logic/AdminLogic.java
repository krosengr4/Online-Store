package logic;

import config.DatabaseConfig;
import data.ProductDao;
import data.mysql.MySqlProductDao;
import models.Product;
import org.apache.commons.dbcp2.BasicDataSource;
import ui.UserInterface;
import utils.Utils;

import java.sql.Connection;

public class AdminLogic {

	static UserInterface ui = new UserInterface();

	static BasicDataSource dataSource = DatabaseConfig.setConnection();
	static ProductDao productDao = new MySqlProductDao(dataSource);

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

	private static void addProduct() {
		int departmentId = Utils.getUserInputInt("Enter the department ID:\n");
		String productName = Utils.getUserInput("Enter the product name:\n");
		double price = Utils.getUserInputDouble("Enter the price:\n$");

		Product product = productDao.add(new Product(0, departmentId, productName, price));
		if(product != null) {
			product.print();
		}

		Utils.pauseApp();
	}

	private static void updateProduct() {
		int productId = Utils.getUserInputInt("Enter the ID of the product to update:\n");
		int userChoice = ui.displayUpdateProduct();

		Product product = productDao.getById(productId);

		switch(userChoice) {
			case 1: {
				int newDepartment = Utils.getUserInputInt("Enter the new department ID:\n");
				product.setDepartmentId(newDepartment);

				break;
			}
			case 2: {
				String newName = Utils.getUserInput("Enter the new product name:\n").trim();
				product.setName(newName);

				break;
			}
			case 3: {
				double newPrice = Utils.getUserInputDouble("Enter the new price:\n$");
				product.setPrice(newPrice);

				break;
			}
		}

		if(userChoice != 0) {
			productDao.update(productId, product);
			Utils.pauseApp();
		}

	}

	private static void deleteProduct() {}

	private static void addCategory() {}

	private static void deleteCategory() {}

}
