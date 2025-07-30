package models;

import java.math.BigDecimal;

public class OrderLineItems implements Printable {

	int lineItemId;
	int orderId;
	int productId;
	int quantity;
	BigDecimal salesPrice;

	public OrderLineItems(int lineItemId, int orderId, int productId, int quantity, BigDecimal salesPrice) {
		this.lineItemId = lineItemId;
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
		this.salesPrice = salesPrice;
	}

	//region Setters and Getters
	public int getLineItemId() {
		return lineItemId;
	}

	public void setLineItemId(int lineItemId) {
		this.lineItemId = lineItemId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(BigDecimal salesPrice) {
		this.salesPrice = salesPrice;
	}
	//endregion

	@Override
	public void print() {
		System.out.println("------ORDER ITEM-----");
		System.out.println("Line Item ID: " + this.lineItemId);
		System.out.println("Order ID: " + this.orderId);
		System.out.println("Product ID: " + this.productId);
		System.out.println("Quantity: " + this.quantity);
		System.out.println("Sales Price: $" + this.salesPrice);
		System.out.println("-------------------------------------------------------------------------");
	}
}
