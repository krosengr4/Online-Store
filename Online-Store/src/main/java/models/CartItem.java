package models;

public class CartItem implements Printable{

	private Product product;
	private int quantity;

	public CartItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	//region Setters and Getters
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	//endregion

	public int getProductId() {
		return this.product.getProductId();
	}

	public double getPrice() {
		return product.getPrice() * quantity;
	}

	public void print() {
		System.out.println("\t-----CART ITEM-----");
		System.out.println("Product Name: " + this.product.getName());
		System.out.println("Quantity: " + this.quantity);
		System.out.println("Price: $" + this.getPrice());
		System.out.println("-----------------------------------------------");
	}
}
