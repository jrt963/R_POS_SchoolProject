package model;

public class OrderItem {
	private String name;
	private double subtotal;

	public OrderItem() {
		subtotal = 0;
	}

	public OrderItem(String itemName, double subtotal) {
		this.name = itemName;
		this.subtotal = subtotal;
	}

	public String getName() {
		return this.name;
	}

	public String getLineItem() {
		String temp;
		temp = (this.name + "................" + this.subtotal);
		return temp;
	}

	public double getSubtotal() {
		return this.subtotal;
	}

	@Override
	public String toString() {
		String temp;
		temp = (this.name + "................" + this.subtotal + "\n");
		return temp;
	}

}
