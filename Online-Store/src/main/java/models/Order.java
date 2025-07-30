package models;

import java.time.LocalDateTime;
import java.util.List;

public class Order implements Printable {

	int orderId;
	LocalDateTime dateTime;
	String customerName;
	String address;
	String state;
	String city;

	public Order() {}

	public Order(int orderId, LocalDateTime dateTime, String customerName, String address, String state, String city) {
		this.orderId = orderId;
		this.dateTime = dateTime;
		this.customerName = customerName;
		this.address = address;
		this.state = state;
		this.city = city;
	}

	//region Setters and Getters
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	//endregion

	public void print() {
		System.out.printf("--------ORDER FOR %s--------\n", this.customerName.toUpperCase());
		System.out.println("Order ID: " + this.orderId);
		System.out.println("Date and Time: " + this.dateTime);
		System.out.println("Address: " + this.address);
		System.out.println("City: " + this.city);
		System.out.println("State: " + this.state);
		System.out.println("--------------------------------------------------------");
	}
}
