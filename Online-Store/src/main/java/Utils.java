import java.sql.Struct;
import java.util.HashMap;
import java.util.Scanner;

public class Utils {

    public static String filePath = "Online-Store/src/main/resources/products.csv";

    static Scanner myScanner = new Scanner(System.in);

    static String getUserInput(String message) {
        System.out.println(message);
        return myScanner.nextLine();
    }

    public static void pauseApp() {
        System.out.println("\n Please press enter to continue...");
        myScanner.nextLine();
    }

}
