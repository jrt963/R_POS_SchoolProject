package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TablePanel extends JPanel {

	private JLabel tableLabel;
	private JButton floorButton;
	private JButton newOrderButton;
	private TabelPanelListener tableListener;
	private int tableNum;
	private NewOrderFrame newOrderFrame;

	public TablePanel() {
		Dimension size = getPreferredSize();
		size.width = 250;
		setPreferredSize(size);

		layoutComponent();

		setBorder(BorderFactory.createTitledBorder("Table Status"));

		floorButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.out.println("floor panel action perform - tbutton");
				TableEvent tableEvent = new TableEvent(this);
				tableListener.tableEventOccurred(tableEvent);
			}
		});
	}

	public TablePanel(int tableNum) {
		this.tableNum = tableNum;
		Dimension size = getPreferredSize();
		size.width = 250;
		setPreferredSize(size);

		layoutComponent();

		setBorder(BorderFactory.createTitledBorder("Table Status"));

		floorButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.out.println("!!floor panel action perform - tbutton");
				TableEvent tableEvent = new TableEvent(this);
				tableListener.tableEventOccurred(tableEvent);
			}
		});
		
		newOrderButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.out.println("Tabel panel action perform - new order");
				//NewOrderEvent newOrderEvent = new NewOrderEvent(this, tableNum);
				//tableListener.newOrderEventOccurred(newOrderEvent);
				newOrderFrame = new NewOrderFrame();

				newOrderFrame.setNewOrderListener(new AddItemListener() {

					@Override
					public void addItemEventOccurred(AddItemEvent event) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void submitOrderEventOccured(NewOrderEvent event) {
						System.out.println("Table panel received submit order");
						if(event.getOrder().size() < 1)
							System.out.println("No item was added to order.");
						newOrderFrame.dispose();
						System.out.println(event.getOrder().toString());
						event.setTableNum(tableNum);
						tableListener.submitOrderEventOccurred(event);
					}

				
					
				});
				
			}
		});
		
	}

	public void setTableListener(TabelPanelListener tableListener) {
		this.tableListener = tableListener;
	}

	public void layoutComponent() {
		tableLabel = new JLabel("Table Number: 1");
		floorButton = new JButton("Back to floor view");
		newOrderButton = new JButton("New order");

		this.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		// First Row//
		gc.gridy = 0;

		gc.weightx = 1;
		gc.weighty = 0.1;

		gc.gridx = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.NORTHWEST;
		gc.insets = new Insets(0, 0, 0, 0);
		add(tableLabel, gc);

		// Final row//
		gc.gridy = 5;

		gc.weightx = 1;
		gc.weighty = 0.1;

		gc.gridx = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.SOUTH;
		gc.insets = new Insets(40, 40, 40, 40);
		add(newOrderButton, gc);

		// Final row//
		gc.gridy = 5;

		gc.weightx = 1;
		gc.weighty = 0.1;

		gc.gridx = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.SOUTH;
		gc.insets = new Insets(0, 0, 0, 5);
		add(floorButton, gc);

		setSize(600, 500);
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
