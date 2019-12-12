package view;
import java.awt.event.ActionListener;
import java.util.EventObject;

public class FloorEvent extends EventObject {

	private int tableNum;
	
	public FloorEvent(Object source, int tableNum) {
		super(source);
		this.setTableNum(tableNum);
	}

	public int getTableNum() {
		return tableNum;
	}

	public void setTableNum(int tableNum) {
		this.tableNum = tableNum;
	}


	

}
