package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;

import controller.Controller;
import model.Floor;

public class MainFrame extends JFrame {

	private FloorPanel floorPanel;
	private TablePanel tablePanel;
	private Controller controller;
	private NewOrderFrame newOrderFrame;
	private Floor floor;
	// private OrderListModel orderListModel;
	// private JTable listOrdersTable;
	private DefaultListModel listModel;
	private JList orderList;

	public MainFrame() {
		super("POS Application");

		setLayout(new BorderLayout());

		listModel = new DefaultListModel();

		orderList = new JList(listModel);

		orderList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		orderList.setSelectedIndex(0);
		// orderList.addListSelectionListener(this);
		orderList.setVisibleRowCount(5);
		JScrollPane listScrollPane = new JScrollPane(orderList);
		
		floor = new Floor();
		floor.addTable();

		controller = new Controller();
		controller.setFloor(floor);

		// Create Swing components

		floorPanel = new FloorPanel();

		floorPanel.setFloorListener(new FloorPanelListener() {

			@Override
			public void floorEventOccurred(FloorEvent event) {
				System.out.println("floor listener in main frame");
				controller.getFloor();
				System.out.println("test in main frame for table list" + floor.toString());

				tablePanel = new TablePanel(event.getTableNum());
				add(tablePanel, BorderLayout.CENTER);
				floorPanel.setVisible(false);
				tablePanel.setVisible(true);

				tablePanel.setTableListener(new TabelPanelListener() {

					@Override
					public void tableEventOccurred(TableEvent event) {
						System.out.println("table listener in main frame");

						floorPanel.setVisible(true);
						remove(tablePanel);

					}

					@Override
					public void submitOrderEventOccurred(NewOrderEvent event) {
						System.out.println("**Main frame received submit order request");
						controller.submitOrder(event);
						List<String> order = event.getOrder();
						listModel.addElement(order);
					}
				});

			}
		});

		add(listScrollPane, BorderLayout.EAST);
		add(floorPanel, BorderLayout.CENTER);

		setMinimumSize(new Dimension(500, 400));
		setSize(600, 500);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
	}

}