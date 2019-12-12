package view;

import java.util.EventListener;

public interface FloorPanelListener extends EventListener {
	public void floorEventOccurred(FloorEvent event);
	// public void floorEventOccurred(FloorEvent event, int tableNum);
}
