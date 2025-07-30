package logic;

import config.DatabaseConfig;
import data.CartDao;
import data.DepartmentDao;
import data.ProductDao;
import data.mysql.MySqlCartDao;
import data.mysql.MySqlDepartmentDao;
import data.mysql.MySqlProductDao;
import models.CartItem;
import models.Department;
import models.Product;
import ui.UserInterface;
import utils.Utils;

import java.util.List;

public class InventoryLogic {

	static UserInterface ui = new UserInterface();
	static ProductDao productDao = new MySqlProductDao(DatabaseConfig.setConnection());
	static DepartmentDao departmentDao = new MySqlDepartmentDao(DatabaseConfig.setConnection());
	static CartDao cartDao = new MySqlCartDao(DatabaseConfig.setConnection());

	public static void processInventoryScreen() {
		boolean ifContinue = true;

		while(ifContinue) {
			int userChoice = ui.displayCart();

			switch(userChoice) {
				case 1 -> displayAll();
				case 2 -> displayByDepartment();
				case 3 -> displayAllDepartments();
				case 4 -> searchByName();
				case 5 -> searchByPrice();
				case 6 -> addToCart();
				case 0 -> ifContinue = false;
			}
		}
	}

	private static void displayAll() {
		List<Product> productList = productDao.getAll();

		printData(productList);
	}

	private static void displayByDepartment() {
		int departmentChoice = Utils.getUserInputInt("Enter the department ID:\n");

		List<Product> productList = productDao.getByDepartment(departmentChoice);
		printData(productList);
	}

	private static void displayAllDepartments() {
		List<Department> departmentList = departmentDao.getAll();

		if(departmentList.isEmpty()) {
			System.out.println("There are no departments to display...");
		} else {
			for(Department department : departmentList) {
				department.print();
			}
		}

		Utils.pauseApp();
	}

	private static void searchByName() {
		String productSearch = Utils.getUserInput("Enter the name of the product:\n");

		List<Product> productList = productDao.searchByName(productSearch);
		printData(productList);
	}

	private static void searchByPrice(){
		double minPrice = Utils.getUserInputDouble("Enter the minimum price:\n$");
		double maxPrice = Utils.getUserInputDouble("Enter the maximum price:\n$");

		List<Product> productList = productDao.searchByPrice(minPrice, maxPrice);
		printData(productList);
	}

	private static void addToCart() {
		int productId = Utils.getUserInputInt("Enter the Product ID:\n");
		int quantity = Utils.getUserInputInt("Enter the quantity:\n");

		Product product = productDao.getById(productId);
		CartItem cartItem = new CartItem(product, quantity);

		cartDao.add(cartItem);
	}

	private static void printData(List<Product> productList) {
		if(productList.isEmpty()) {
			System.out.println("There are no products to display...");
		} else {
			for(Product product : productList) {
				product.print();
			}
		}

		Utils.pauseApp();
	}

}
