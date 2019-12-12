package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Datastore {

	private List<Table> tables;
	private List<Order> orderQue;
	private List<Order> ordersCompleted;
	
	public Datastore() {
		this.setTables(new ArrayList<Table>());
		this.setOrderQue(new LinkedList<Order>());
		this.setOrdersCompleted(new ArrayList<Order>());
		}

	public List<Table> getTables() {
		return tables;
	}

	public void setTables(List<Table> tables) {
		this.tables = tables;
	}

	public List<Order> getOrderQue() {
		return orderQue;
	}

	public void setOrderQue(List<Order> orderQue) {
		this.orderQue = orderQue;
	}

	public List<Order> getOrdersCompleted() {
		return ordersCompleted;
	}

	public void setOrdersCompleted(List<Order> ordersCompleted) {
		this.ordersCompleted = ordersCompleted;
	}
	
	public void addOrderToQue(Order order) {
		orderQue.add(order);
	}
}
