package view;

import java.util.EventObject;

public class AddItemEvent extends EventObject  {

	private String itemName;
	
	public AddItemEvent(Object source, String itemName) {
		super(source);
		this.setItemName(itemName);
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

}
