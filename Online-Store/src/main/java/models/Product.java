package models;

public class Product {

	int productId;
	int departmentId;
	String sku;
	String name;
	double price;

	public Product(int productId, int departmentId, String sku, String name, double price) {
		this.productId = productId;
		this.departmentId = departmentId;
		this.sku = sku;
		this.name = name;
		this.price = price;
	}

	//region Getters and Setters
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	//endregion

	public void print() {
		System.out.println("-----PRODUCT-----");
		System.out.println("Product ID: " + this.productId);
		System.out.println("Department ID: " + this.departmentId);
		System.out.println("Name: " + this.name);
		System.out.println("Price: $" + this.price);
		System.out.println("----------------------------------------------");
	}
}
