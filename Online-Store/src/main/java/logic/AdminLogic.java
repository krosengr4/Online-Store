package logic;

import config.DatabaseConfig;
import data.DepartmentDao;
import data.ProductDao;
import data.mysql.MySqlDepartmentDao;
import data.mysql.MySqlProductDao;
import models.Department;
import models.Product;
import org.apache.commons.dbcp2.BasicDataSource;
import ui.UserInterface;
import utils.Utils;

public class AdminLogic {

	static UserInterface ui = new UserInterface();

	static BasicDataSource dataSource = DatabaseConfig.setConnection();
	static ProductDao productDao = new MySqlProductDao(dataSource);
	static DepartmentDao departmentDao = new MySqlDepartmentDao(dataSource);

	public static void processAdminScreen() {
		boolean ifContinue = true;

		while(ifContinue) {
			int adminChoice = ui.displayAdminScreen();

			switch(adminChoice) {
				case 1 -> addProduct();
				case 2 -> updateProduct();
				case 3 -> deleteProduct();
				case 4 -> addDepartment();
				case 5 -> deleteDepartment();
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

	private static void deleteProduct() {
		int productId = Utils.getUserInputInt("Enter the product ID to delete:\n");
		productDao.delete(productId);

		Utils.pauseApp();
	}

	private static void addDepartment() {
		String departmentName = Utils.getUserInput("Enter the name of the new department:\n").trim().toLowerCase();
		Department department = departmentDao.add(new Department(0, departmentName));

		if(department != null) {
			department.print();
		}

		Utils.pauseApp();
	}

	private static void deleteDepartment() {}

}
