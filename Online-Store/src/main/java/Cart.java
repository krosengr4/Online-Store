public class Cart {

    public static void displayCartMenu() {
        boolean ifContinue = true;

        while (ifContinue) {
            System.out.println("\n\t\t---YOUR CART---");
        System.out.println("OPTIONS: \n\t1 - Check Out \n\t2 - Remove a product from the cart \n\t3 - Return to Home Page");
        String userAction = Utils.getUserInput("Enter the number of what you'd like to do: ").trim();

            switch (userAction) {
                case "1" -> checkOut();
                case "2" -> removeItem();
                case "3" -> ifContinue = false;
                default -> System.out.println("ERROR! Please Enter a Number Between 1-3");
            }
        }


    }

    public static void checkOut() {
        System.out.println("Check Out");
    }

    public static void removeItem() {
        System.out.println("Remove Item");
    }


}
