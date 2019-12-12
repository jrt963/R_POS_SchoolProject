package view;

import java.util.EventListener;

public interface TabelPanelListener extends EventListener {
	public void tableEventOccurred(TableEvent event);
	public void submitOrderEventOccurred(NewOrderEvent event);
}
