import java.util.HashMap;

public class Inventory {

    public static void displayInventoryMenu() {

        boolean ifContinue = true;

        while(ifContinue) {
            System.out.println("\n\t\t---INVENTORY---");
            System.out.println("OPTIONS: \n\t1 - Search For Product \n\t2 - Add Product to Cart \n\t3 - Return to Home Page");
            String userAction = Utils.getUserInput("Enter the number of what you'd like to do: ").trim();

            switch (userAction) {
                case "1" -> searchProduct();
                case "2" -> addToCart();
                case "3" -> ifContinue = false;
                default -> System.err.println("ERROR! Please enter a number between 1 and 3!");
            }
        }
    }

    public static void searchProduct() {

        HashMap<String, Product> inventory = Main.loadInventory();

        String productSearch = Utils.getUserInput("Enter a product name: ");
        Product matchProduct = inventory.get(productSearch);

        if (matchProduct == null) {
            System.out.println("We don't have that product in stock.");
        } else {
            System.out.println("Here is what we have in stock: \n" + matchProduct.getName() + " $" + matchProduct.getPrice());
        }
        Utils.pauseApp();
    }

    public static void addToCart() {
        System.out.println("Add to cart");
    }

}
