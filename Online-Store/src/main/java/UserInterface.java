public class UserInterface {

	public int displayHomePage() {
		System.out.println("\n\t-----HOME PAGE-----");
		System.out.println("""
					---OPTIONS---
				1 - Go to Inventory Screen
				2 - Go to Cart Screen
				0 - Exit
				""");

		return Utils.getUserInputIntMinMax("Enter here:\n", 0, 2);
	}

}
