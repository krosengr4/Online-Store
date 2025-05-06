import java.util.Scanner;

public class Utils {

    String filePath = "Online-Store/src/main/resources/products.csv";

    static String getUserInput(String message) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println(message);
        return myScanner.nextLine();
    }

}
