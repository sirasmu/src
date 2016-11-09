package WIP.data;

import java.io.Serializable;
import java.util.Iterator;

import WIP.data.utility.ArrayList;
import WIP.data.utility.ListADT;

public class ReservedList implements Serializable, Iterable<Reserved> {

	private ListADT<Reserved> reservedList;

	/**
	 * The list for Reserved objects is initialized
	 */
	public ReservedList() {
		reservedList = new ArrayList<>();
	}

	/**
	 * @return a list of all reservations saved in a binary file stored in the server
	 */
	public ListADT<Reserved> getAll() {
		return reservedList;
	}
	
	/**
	 * @param index of the Reserved object
	 * @return Reserved object
	 */
	public Reserved get(int index) {
		return reservedList.get(index);
	}

	/**
	 * @param reserved is the new object to add in the end of the list
	 */
	public void add(Reserved reserved) {
		reservedList.add(reserved);
	}
	
	/**
	 * @param reserved is the object to remove from the list
	 */
	public Reserved remove(Reserved reserved) {
		return reservedList.remove(reserved);
	}
	
	/**
	 * @return size of list
	 */
	public int size() {
		return reservedList.size();
	}
	
	/**
	 * Every object in the list is printed out in order
	 */
	public String toString() {
		StringBuilder str = new StringBuilder("****CURRENT RESERVATIONS****\n");
		for (int i = 0; i < reservedList.size(); i++) {
			str.append(get(i) + "\n");
		}
		str.append("END");
		return str.toString();
	}

	@Override
	public Iterator<Reserved> iterator() {
		return reservedList.iterator();
	}

}
