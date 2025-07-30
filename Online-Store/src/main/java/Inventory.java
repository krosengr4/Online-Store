import models.Product;
import utils.Utils;

import java.util.ArrayList;

public class Inventory {

    public static ArrayList<Product> userCart = new ArrayList<>();

    public static void displayInventoryMenu() {

        boolean ifContinue = true;

        while (ifContinue) {
            System.out.println("\n\t\t---INVENTORY---");
            System.out.println("OPTIONS: \n\t1 - Display All Products \n\t2 - Search For models.Product \n\t3 - Add models.Product to Cart \n\t4 - Return to Home Page");
            String userAction = Utils.getUserInput("Enter the number of what you'd like to do: ").trim();

            switch (userAction) {
                case "1" -> displayProducts();
                case "2" -> searchProduct();
                case "3" -> addToCart();
                case "4" -> ifContinue = false;
                default -> System.err.println("ERROR! Please enter a number between 1 and 4!");
            }
        }
    }

    public static void displayProducts() {
        System.out.println("\t---ALL PRODUCTS---");
        ArrayList<Product> inventory = Main.loadInventory();

        if (inventory.isEmpty()) {
            System.out.println("We do not have any products at the moment.");
        }

        for (Product p : inventory) {
            System.out.println("models.Product Name: " + p.getName() + "\nPrice : $" + p.getPrice());
        }
        Utils.pauseApp();
    }

    public static void searchProduct() {

        ArrayList<Product> inventory = Main.loadInventory();

        String productSearch = Utils.getUserInput("Enter a product name: ");

        for (Product p : inventory) {
            if (productSearch.equalsIgnoreCase(p.getName())) {
                System.out.println("\nIn Stock: \n" + p.getName() + " $" + p.getPrice());
            }
        }
        Utils.pauseApp();
    }

    public static void addToCart() {

        ArrayList<Product> inventory = Main.loadInventory();
        boolean continueToAdd = true;

        while (continueToAdd) {
            String productToAdd = Utils.getUserInput("Enter the product you would like to add: ").trim();

            for (Product p : inventory) {
                if (productToAdd.equalsIgnoreCase(p.getName())) {
                    Product cartProduct = new Product(p.getProductId(), p.getDepartmentId(), p.getSku(), p.getName(), p.getPrice());
                    userCart.add(cartProduct);
                    System.out.println("Success! You have added " + p.getName() + " to your cart!");
                }
            }
            Utils.pauseApp();
            String userOption = Utils.getUserInput("Would you like to add another item? (Y or N): ").trim();
            if (userOption.equalsIgnoreCase("n")) {
                continueToAdd = false;
            } else if (!userOption.equalsIgnoreCase("y")){
                System.err.println("Please enter y or n");
                break;
            }
        }
    }

}
