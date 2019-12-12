package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import model.Menu;

public class MenuPanel extends JPanel {

	private Menu menu;
	private Set<Map.Entry<String, Double>> items;
	private JButton buttons[];
	private AddItemListener addItemListener;
	static int btnIndex;
	
	public MenuPanel() {
		Dimension size = getPreferredSize();
		size.width = 250;
		setPreferredSize(size);

		menu = new Menu();
		items = menu.getMenu();

		layoutComponent();

		setBorder(BorderFactory.createTitledBorder("Add item"));

		for (btnIndex = 0; btnIndex < buttons.length; btnIndex++) {
			
			System.out.println("test in menu panel before action listener : " + buttons[btnIndex].getText());
			buttons[btnIndex].addActionListener(new ActionListener() {
				
				String temp = buttons[btnIndex].getText();
				public void actionPerformed(ActionEvent e) {
					
					System.out.println("Menu panel - add item test line: item name.. " + temp);

					AddItemEvent addItemEvent = new AddItemEvent(this, temp);
					addItemListener.addItemEventOccurred(addItemEvent);
				}
			});

		}
	}

	public void setAddItemListener(AddItemListener addItemListener) {
		this.addItemListener = addItemListener;
	}

	public void layoutComponent() {

		this.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.gridy = 0;

		buttons = new JButton[items.size()];
		int i = 0;
		Iterator<Entry<String, Double>> keyIterator = items.iterator();
		while (keyIterator.hasNext()) {
			Entry<String, Double> temp = keyIterator.next();
			System.out.println("test in new order frame" + temp.toString());

			JButton btn = new JButton(temp.toString());
			buttons[i] = btn;
			;
			// Row//

			gc.weightx = 1;
			gc.weighty = 0.1;

			gc.gridx = 0;
			gc.fill = GridBagConstraints.BOTH;
			gc.anchor = GridBagConstraints.WEST;
			btn.setMargin(new Insets(5, 0, 0, 0));
			add(btn, gc);
			gc.gridy++;
			i++;
		}

		setSize(600, 500);
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

}
