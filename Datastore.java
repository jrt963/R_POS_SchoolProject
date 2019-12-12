package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
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
	
	public void saveToFile(File file) throws IOException {
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		/*
		 * Cave of programming preferred changing ArrayList<Person> into
		 * Person[] = people.toArray..
		 * The reasoning was for better I/O to file. 
		 * ArrayList suffers from "uncheck conversion warning"...
		 * 
		 */
		Order[] orderArray = orderQue.toArray(new Order[orderQue.size()]);
		
		oos.writeObject(orderArray);
		
		oos.close();
	}
	
	public void loadFromFile(File file) throws IOException {
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		
		try {
			Order[ ]orderArray = (Order[])ois.readObject();
			
			orderQue.clear();
			orderQue.addAll(Arrays.asList(orderArray));
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		ois.close();
	}
}
