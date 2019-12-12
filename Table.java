package model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Table {

	private int tableNum;
	private double subtotal;
	private TableStatus status;
	private List<Order> orders;

	// default constructor
	public Table() {
		subtotal = 0;
		orders = new ArrayList<Order>();
	}

	public Table(int num) {
		tableNum = num;
		subtotal = 0;
		orders = new ArrayList<Order>();
	}

	public void addOrder(Order o) {
		orders.add(o);
		this.subtotal = this.subtotal + o.getTotal();
	}

	public double getTotal() {
		for (int i = 0; i <= orders.lastIndexOf(orders); i++)
			subtotal = subtotal + orders.get(i).getTotal();
		return subtotal;
	}

	public void printOrders() {
		int index = 0;
		for (Order o : orders) {
			System.out.println(o.getOrderList().toString());
		}
	}

	public String toString() {
		String temp;
		temp = ("Table #" + tableNum + " " + getStatus());
		return temp;
	}

	public TableStatus getStatus() {
		return status;
	}

	public void setStatus(TableStatus status) {
		this.status = status;
	}

}
