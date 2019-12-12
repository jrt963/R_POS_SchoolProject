package controller;

import java.util.List;

import javax.swing.SwingUtilities;

import model.Datastore;
import model.Floor;
import model.Order;
import model.OrderStatus;
import model.Table;
import view.MainFrame;
import view.NewOrderEvent;

public class Controller {

	private static int orderNumber;
	private Datastore db = new Datastore();
	private Floor floor;
	private MainFrame mainFrame;
	
	public Controller() {
		orderNumber = 0;
	}

	public List<Table> getFloor() {
		System.out.println("test getFloor");
		List<Table> temp = this.floor.getTableList();
		System.out.println(temp);
		return temp;
	}

	public void setFloor(Floor floor) {
		this.floor = floor;
	}
	
	public void submitOrder(NewOrderEvent event) {
		System.out.println("Controller received order...");
		System.out.println("*****************************");
		System.out.println(event.getOrder().toString());
		
		orderNumber++;
		Order newOrder = new Order(event.getOrder());
		OrderStatus orderStatus = OrderStatus.pending;
		newOrder.setOrderStatus(orderStatus );
		newOrder.setOrderNumber(orderNumber);
		newOrder.setTableNum(event.getTableNum());
		
		System.out.println(newOrder.toString());
		double subtotal = newOrder.getTotal();
		System.out.println("Subtotal before tax: " + subtotal);
		
		
		db.addOrderToQue(newOrder);
		
	}
	
	public List<Order> viewOrderQue() {
		List<Order> orQue = db.getOrderQue();
		return orQue;
	}
	
	
}
