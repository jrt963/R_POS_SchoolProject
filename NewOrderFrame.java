package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

import model.Menu;

public class NewOrderFrame extends JFrame {

	private MenuPanel menuPanel;
	private JList orderList;
	private DefaultListModel listModel;
	private JButton submitOrderBtn;
	private AddItemListener newOrderListener;
	
	public NewOrderFrame() {
		super("New order");
		Dimension dimension = getPreferredSize();
		dimension.width = 250;
		setPreferredSize(dimension);
		
		submitOrderBtn = new JButton("Submit order");
		
		menuPanel = new MenuPanel();
		
		listModel = new DefaultListModel();
		
		orderList = new JList(listModel);
		orderList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		orderList.setSelectedIndex(0);
		//orderList.addListSelectionListener(this);
		orderList.setVisibleRowCount(5);
        JScrollPane listScrollPane = new JScrollPane(orderList);
		
		
		add(menuPanel, BorderLayout.WEST);
		add(listScrollPane, BorderLayout.CENTER);
		add(submitOrderBtn, BorderLayout.SOUTH);
		
		setMinimumSize(new Dimension(500,400));
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		
		List<String> order = new ArrayList<String>();
		
		menuPanel.setAddItemListener(new AddItemListener() {

			@Override
			public void addItemEventOccurred(AddItemEvent event) {
				System.out.println("Test in New Order Frame : " + event.getItemName());
				order.add(event.getItemName());
				listModel.addElement(event.getItemName());
			}

			@Override
			public void submitOrderEventOccured(NewOrderEvent event) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		submitOrderBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.out.println("Submit button pressed");
				NewOrderEvent newOrderEvent = new NewOrderEvent(this, order);
				newOrderListener.submitOrderEventOccured(newOrderEvent);
			}
		});
		
	}

	public AddItemListener getNewOrderListener() {
		return newOrderListener;
	}

	public void setNewOrderListener(AddItemListener newOrderListener) {
		this.newOrderListener = newOrderListener;
	}
	

}
