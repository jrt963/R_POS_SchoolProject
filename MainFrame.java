package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import controller.Controller;
import model.Floor;
import model.Table;

public class MainFrame extends JFrame {

	private FloorPanel floorPanel;
	private TablePanel tablePanel;
	private Controller controller;
	private NewOrderFrame newOrderFrame;
	private Floor floor;

	public MainFrame() {
		super("POS Application");

		setLayout(new BorderLayout());
		
		floor = new Floor();
		floor.addTable();
		
		controller = new Controller();
		controller.setFloor(floor);

		// Create Swing components

		floorPanel = new FloorPanel();
		

		floorPanel.setFloorListener(new FloorPanelListener() {

			public void floorEventOccurred(FloorEvent event) {
				System.out.println("floor listener in main frame");
				controller.getFloor();
				System.out.println("test in main frame for table list" + floor.toString());
				
				tablePanel = new TablePanel(event.getTableNum());
				add(tablePanel, BorderLayout.CENTER);
				floorPanel.setVisible(false);
				tablePanel.setVisible(true);
			      
				tablePanel.setTableListener(new TabelPanelListener() {

					public void tableEventOccurred(TableEvent event) {
						System.out.println("table listener in main frame");
						
						floorPanel.setVisible(true);
						remove(tablePanel);
					      
						
					}

					@Override
					public void submitOrderEventOccurred(NewOrderEvent event) {
						System.out.println("**Main frame received submit order request");
						controller.submitOrder(event);
					}
				});

				
			}
		});
		
	
		// Add Swing components to content pane.
		//Container c = getContentPane();

		// c.add(button, BorderLayout.SOUTH);
		add(floorPanel, BorderLayout.CENTER);
		
		setMinimumSize(new Dimension(500,400));
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	
}