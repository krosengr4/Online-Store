public class Main {

    public static void main(String[] args) {
        System.out.println("_____WELCOME TO THE ONLINE STORE_____");
        String filePath = "Online-Store/src/main/resources/products.csv";

        int userHSAction = getHomeScreenAction();

        switch (userHSAction) {
            case 1:
                Inventory.displayInventoryMenu();
                break;
            case 2:
                Cart.displayCartMenu();
                break;
            case 3:
                System.out.println("Thank you for using the Online Store! \n\tPlease come again soon! :)");

        }

    }

    public static int getHomeScreenAction() {
        //Get number user inputs and return it
        System.out.println("1 - Inventory \n2 - Cart \n3 - Exit");
        int userAction = Integer.parseInt(Utils.getUserInput("Please enter the number of where you'd like to go: "));
        return userAction;
    }
}

