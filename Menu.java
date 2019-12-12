package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**Menu class represents the list of items being sold.
 * 
 */

/**
 * @author JT
 *
 */
public class Menu {

	// default constructor
	private Map<String, Double> entree = new HashMap<>();

	public Map<String, Double> getEntree() {
		return entree;
	}

	public void setEntree(Map<String, Double> entree) {
		this.entree = entree;
	}

	public Menu() {
		entree.put("Hamburger", 10.99);
		entree.put("Hotdog", 6.99);
		entree.put("Mac and Cheese", 7.99);
		entree.put("Tacos", 6.99);
		entree.put("Quesadilla", 7.99);
	}

	public void printAll() {
		Set<Map.Entry<String, Double>> entries = entree.entrySet();
		System.out.println(entries.toString());
	}

	public double getPrice(String item) {
		return entree.get(item);
	}

	public Set<Map.Entry<String, Double>> getMenu() {
		return entree.entrySet();
	}

	public void setMenu(Set<Map.Entry<String, Double>> m) {
		entree.clear();
	}

	public boolean contains(String itemName) {
		return entree.containsKey(itemName);
	}

}
