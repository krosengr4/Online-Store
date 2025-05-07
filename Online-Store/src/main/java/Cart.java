import java.util.ArrayList;

public class Cart {

    public static void displayCartMenu() {
        boolean ifContinue = true;

        while (ifContinue) {
            System.out.println("\n\t\t---YOUR CART---");
        System.out.println("OPTIONS: \n\t1 - Display your cart \n\t2 - Check Out \n\t3 - Remove a product from the cart \n\t4 - Return to Home Page");
        String userAction = Utils.getUserInput("Enter the number of what you'd like to do: ").trim();

            switch (userAction) {
                case "1" -> displayCart();
                case "2" -> checkOut();
                case "3" -> removeItem();
                case "4" -> ifContinue = false;
                default -> System.out.println("ERROR! Please Enter a Number Between 1-4");
            }
        }


    }

    public static void displayCart() {
        System.out.println("\t---YOUR CART---");

        ArrayList<Product> userCart = Inventory.userCart;

        if (userCart.isEmpty()) {
            System.out.println("There are no items in your cart.");
        } else {
            for (Product p : userCart) {
                System.out.println(p.getName() + " $" + p.getPrice());
            }
        }
        Utils.pauseApp();
    }

    public static void checkOut() {
        System.out.println("Check Out");
    }

    public static void removeItem() {
        System.out.println("Remove Item");
    }


}
