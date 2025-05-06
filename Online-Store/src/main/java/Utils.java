import java.util.HashMap;
import java.util.Scanner;

public class Utils {

    public static String filePath = "Online-Store/src/main/resources/products.csv";

    public static HashMap<String, Product> storeInventory = new HashMap<>();
    public static HashMap<String, Product> userCart = new HashMap<>();

    static String getUserInput(String message) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println(message);
        return myScanner.nextLine();
    }

}
