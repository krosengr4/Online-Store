public class Inventory {

    public static void displayInventoryMenu() {

        int userAction;

        while(true) {
            System.out.println("\n\t---INVENTORY---");
            System.out.println("OPTIONS: \n1 - Search For Product \n2 - Add Product to Cart \n3 - Return to Home Page");
            userAction = Integer.parseInt(Utils.getUserInput("Enter the number of what you'd like to do: "));

            if (userAction == 1) {
                System.out.println("Enter product name.");
                String userSearch = Utils.getUserInput("Search: ");
                searchProduct(userSearch);
            } else if (userAction == 2) {
                System.out.println("Add a product to cart");
                //! Create method in Cart.java class and add here!!!!!!!!!!!!!!!
            } else if (userAction == 3) {
                break;
            } else {
                System.err.println("ERROR! Please enter a number between 1 and 3!");
            }
        }
    }

    public static void searchProduct(String userSearch) {
        System.out.println("Searching for: " + userSearch);

    }

}
