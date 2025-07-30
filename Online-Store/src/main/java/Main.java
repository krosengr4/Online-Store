import utils.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

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

    public static ArrayList<Product> loadInventory() {

        ArrayList<Product> storeInventory = new ArrayList<>();

        try {
            BufferedReader bufReader = new BufferedReader(new FileReader(Utils.filePath));

            String input;

            while ((input = bufReader.readLine()) != null) {
                String [] lineData = input.split("\\|");

                if(lineData[0].equals("SKU")) {
                    continue;
                }

                String id = lineData[0];
                String productName = lineData[1];
                double productPrice = Double.parseDouble(lineData[2]);
                String productDepartment = lineData[3];

                Product newProduct = new Product(id, productName, productPrice, productDepartment);
                storeInventory.add(newProduct);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return storeInventory;
    }
}

