package model;

import java.io.Serializable;
import java.util.List;

public class Order implements Serializable {

	private int orderNumber;
	private List<String> lineItemList;
	private double subtotal;
	private OrderStatus orderStatus;
	private int tableNum;

	// Menu menu;
	// default constructor
	public Order() {
		subtotal = 0;
		setOrderStatus(OrderStatus.pending);
		lineItemList.clear();
	}

	public Order(List<String> orderItems) {
		this.lineItemList = orderItems;
	}

	public void addItem(String orderItem) {
		lineItemList.add(orderItem);

	}

	// This method is untested
	public void removeItem(OrderItem orderItem) {
		lineItemList.remove(orderItem);
	}

	public List<String> getOrderList() {
		return lineItemList;
	}

	public double getTotal() {
		int i;
		String c;
		double sub = 0;
		for (i = 0; i < lineItemList.size(); i++) {
			String temp = lineItemList.get(i);
			c = temp.substring(temp.indexOf('=') + 1);
			sub = sub + Double.parseDouble(c);
		}
		subtotal = sub;
		return subtotal;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public int getTableNum() {
		return tableNum;
	}

	public void setTableNum(int tableNum) {
		this.tableNum = tableNum;
	}

	@Override
	public String toString() {
		String temp = ("Order Number: " + orderNumber + "\n" + "Table Number: " + tableNum + "\n" + "Order status: "
				+ orderStatus.toString() + "\n" + lineItemList.toString());
		return temp;
	}

}
