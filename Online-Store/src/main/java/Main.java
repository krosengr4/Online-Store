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
        return 0;
    }


}

