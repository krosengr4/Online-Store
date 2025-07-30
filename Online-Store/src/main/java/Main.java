import logic.HomeLogic;
import logic.InventoryLogic;
import models.Product;
import utils.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		System.out.println("\t\t_____WELCOME TO THE ONLINE STORE_____");
		HomeLogic.processHomeScreen();
		System.out.println("Thank you for shopping with us! \nWe will see you soon!");
	}

}
