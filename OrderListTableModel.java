package view;

import java.util.List;

import model.Order;

public class OrderListTableModel {

	private List<Order> orders;
	
	private String[] colNames = {"Table Number", "Order Number", "Occupation", "Example Category", "Employment Category",
			"Citizen ID", "Citizenship", "Gender"};
}
