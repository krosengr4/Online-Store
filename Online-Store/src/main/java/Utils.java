import java.util.Scanner;

public class Utils {

    static String getUserInput(String message) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println(message);
        String userInput = myScanner.nextLine();
        return userInput;
    }

}
