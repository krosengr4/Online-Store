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

        ArrayList<Product> userCart = Inventory.userCart;

        if (userCart.isEmpty()) {
            System.out.println("There are no items in your cart. \nYou can add items to your cart from inventory screen!");
        } else {
            System.out.println("YOUR CART: ");
            double totalPrice = 0;
            for (Product p : userCart) {
                System.out.println(p.getName() + " $" + p.getPrice());
                totalPrice += p.getPrice();
            }
            System.out.println("Total Amount: $" + totalPrice);
        }
        Utils.pauseApp();
    }

    public static void checkOut() {
        System.out.println("\t---CHECKOUT---");

        displayCart();
    }

    public static void removeItem() {
        System.out.println("Remove Item");
    }


}
