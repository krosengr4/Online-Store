import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {

    public static void displayInventoryMenu() {

        boolean ifContinue = true;

        while(ifContinue) {
            System.out.println("\n\t\t---INVENTORY---");
            System.out.println("OPTIONS: \n\t1 - Display All Products \n\t2 - Search For Product \n\t3 - Add Product to Cart \n\t4 - Return to Home Page");
            String userAction = Utils.getUserInput("Enter the number of what you'd like to do: ").trim();

            switch (userAction) {
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

        for (int i = 0; i < inventory.size(); i++) {



        }

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
        System.out.println("Add to cart");
    }

}
