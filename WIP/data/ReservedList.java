package WIP.data;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Iterator;


import utility.observer.RemoteObserver;
import utility.observer.RemoteSubject;
import utility.observer.RemoteSubjectDelegate;
import WIP.data.utility.ArrayList;
import WIP.data.utility.ListADT;


public class ReservedList implements Serializable, RemoteSubject<ReservedList>, Iterable<Reserved> {

	
	private ListADT<Reserved> reservedList;
	private RemoteSubjectDelegate<ReservedList> rsd;
	/**
	 * The list for Reserved objects is initialized
	 */
	public ReservedList() {
		reservedList = new ArrayList<>();
		 rsd = new RemoteSubjectDelegate<>(this);
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

	public void addObserver(RemoteObserver<ReservedList> arg0)
			throws RemoteException {

		rsd.addObserver(arg0);
	}

	@Override
	public void deleteObserver(RemoteObserver<ReservedList> arg0)
			throws RemoteException {
		rsd.deleteObserver(arg0);
	}

	public Iterator<Reserved> iterator() {
		return reservedList.iterator();

	}

}
