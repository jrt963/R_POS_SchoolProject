package view;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Order;

public class OrderListModel extends AbstractTableModel {

	private List<Order> orders;
	private String[] colNames = { "Table Number", "Order Number", "Item Name", "Subtotal" };

	public OrderListModel() {

	}

	@Override
	public String getColumnName(int column) {
		return colNames[column];
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return orders.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Order order = orders.get(rowIndex);
		System.out.println("Test in order list model");

		switch (columnIndex) {
		case 0:
			return order.getTableNum();
		case 1:
			return order.getOrderNumber();
		case 2:
			return order.getOrderList();
		case 3:
			return order.getTotal();
		}

		return null;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
