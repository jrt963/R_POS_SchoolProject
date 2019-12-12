package view;
import java.awt.event.ActionListener;
import java.util.EventObject;
import java.util.List;

import model.Order;

public class NewOrderEvent extends EventObject {

	private List<String> order;
	

	private int tableNum;
	
	public NewOrderEvent(Object source) {
		super(source);
	}
	
	public NewOrderEvent(Object source, int tableNum) {
		super(source);
		this.order = order;
	}
	
	public NewOrderEvent(Object source, List<String> order) {
		super(source);
		this.order = order;
	}
	
	public NewOrderEvent(Object source, List<String> order, int tableNum) {
		super(source);
		this.order = order;
		this.setTableNum(tableNum);
	}

	public int getTableNum() {
		return tableNum;
	}

	public void setTableNum(int tableNum) {
		this.tableNum = tableNum;
	}
	
	public List<String> getOrder() {
		return order;
	}
	
	


	

}