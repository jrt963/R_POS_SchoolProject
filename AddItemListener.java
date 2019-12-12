package view;

import java.util.EventListener;

public interface AddItemListener extends EventListener {
	public void addItemEventOccurred(AddItemEvent event);
	public void submitOrderEventOccured(NewOrderEvent event);
	
}
