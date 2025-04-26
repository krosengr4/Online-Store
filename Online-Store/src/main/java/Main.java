public class Main {

    public static void main(String[] args) {
        System.out.println("_____WELCOME TO THE ONLINE STORE_____");
        String filePath = "Online-Store/src/main/resources/products.csv";

        int userHSAction;


        userHSAction = getHomeScreenAction();

        switch (userHSAction) {
            case 1:
                Inventory.displayInventoryMenu();
            case 2:
                Cart.displayCartMenu();
            case 3:
                System.out.println("Thank you for using the Online Store! \n\tPlease come again soon! :)");
                break;
            default:
                System.err.println("ERROR: Please choose a number between 1 and 3!");
        }

    }

    public static int getHomeScreenAction() {
        System.out.println("\n\t---HOME PAGE---");
        //Get number user inputs and return it
        System.out.println("1 - Inventory \n2 - Cart \n3 - Exit");
        int userAction = Integer.parseInt(Utils.getUserInput("Please enter the number of where you'd like to go: "));
        return userAction;
    }
}

