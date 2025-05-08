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
            System.out.println("There are no items in your cart. \nYou can add items to your cart from inventory screen!");
        } else {
            double totalPrice = 0;
            for (Product p : userCart) {
                System.out.println(p.getName() + " $" + p.getPrice());
                totalPrice += p.getPrice();
            }
            System.out.printf("Total Amount: $%.2f", totalPrice);
        }
        Utils.pauseApp();
    }

    public static void checkOut() {
        displayCart();

        System.out.println("\t---CHECKOUT---");

        System.out.println("OPTIONS:\n\tC - Credit \n\tD - Debit");
        String userPayment = Utils.getUserInput("How would you like to pay: ").trim();

        if (userPayment.equalsIgnoreCase("c") || userPayment.equalsIgnoreCase("d")) {
            String userCCNumber = Utils.getUserInput("Enter your card number: ");
            String userCCExpiration = Utils.getUserInput("Enter the expiration date: ");
            String userCCCVV = Utils.getUserInput("Enter the 3 digit CVV: ");
        } else {
            System.err.println("Error! Please enter either c or d.");
        }
        System.out.println("Thank you for your purchase! You will be sent an email with details of your purchase!");
    }

    public static void removeItem() {
        System.out.println("Remove Item");
    }


}
