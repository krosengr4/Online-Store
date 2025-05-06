public class Main {

    public static void main(String[] args) {
        System.out.println("\t\t_____WELCOME TO THE ONLINE STORE_____");
        displayHomeScreen();
        System.out.println("Thank you for shopping with us! \nWe will see you soon!");




    }

    public static void displayHomeScreen() {

        boolean ifContinue = true;

        while (ifContinue) {
            System.out.println("\n\t---HOME PAGE---");
            //Get number user inputs and return it
            System.out.println("OPTIONS: \n\t1 - Inventory \n\t2 - Cart \n\t3 - Exit");
            String userAction = Utils.getUserInput("Enter the number of what you'd like to do: ").trim();


            switch (userAction) {
                case "1" -> Inventory.displayInventoryMenu();
                case "2" -> Cart.displayCartMenu();
                case "3" -> ifContinue = false;
                default -> System.err.println("ERROR: Please choose a number between 1 and 3!");
            }

        }
    }
}

