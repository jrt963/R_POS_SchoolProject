package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class FloorPanel extends JPanel {

	private JButton tButton;
	private FloorPanelListener floorListener;

	public FloorPanel() {
		Dimension size = getPreferredSize();
		size.width = 250;
		setPreferredSize(size);

		setBorder(BorderFactory.createTitledBorder("Floor Status"));
		layoutComponent();

		tButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("floor panel action perform - tbutton");
				FloorEvent floorEvent;
				floorEvent = new FloorEvent(this, 1);
				floorListener.floorEventOccurred(floorEvent);
			}
		});

	}

	public void setFloorListener(FloorPanelListener floorListener) {
		this.floorListener = floorListener;
	}

	public void layoutComponent() {
		tButton = new JButton("Table 1 Button");

		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		// First Row//
		gc.gridy = 0;

		gc.weightx = 1;
		gc.weighty = 0.1;

		gc.gridx = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.CENTER;
		gc.insets = new Insets(0, 0, 0, 5);
		add(tButton, gc);

		setSize(600, 500);
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
