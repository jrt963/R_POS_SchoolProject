package model;

import java.util.ArrayList;
import java.util.List;

public class Floor {
	private List<Table> tableList;

	public Floor() {
		tableList = new ArrayList<Table>();
	}

	public Floor(int num) {
		tableList = new ArrayList<Table>();
		for (int i = 0; i < num; i++)
			addTable();
	}

	public void addTable() {
		Table table;
		table = new Table(tableList.size() + 1);
		tableList.add(table);
	}

	public void showAll() {
		System.out.println(tableList.toString());
	}

	@Override
	public String toString() {
		return tableList.toString();
	}

	public Table getTable(int tableNum) {
		return tableList.get(tableNum - 1);
	}

	public List<Table> getTableList() {
		return tableList;
	}

	public void setTableList(List<Table> tableList) {
		this.tableList = tableList;
	}

}
