package ClientConsole;

import java.nio.channels.IllegalSelectorException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import WIP.data.Reserved;
import WIP.data.ReservedList;
import WIP.data.utility.TheTime;

public class ClientController extends UnicastRemoteObject implements RemoteObserver {

	private InterfaceModel model;
	private ClientView view;

	public ClientController(InterfaceModel model, ClientView view) throws RemoteException {
		this.model = model;
		this.view = view;
		view.addController(this);
		model.addObserver(this);
		view.displayMenu();
	}

	public ReservedList getAll() {
		try {
			return model.getAll();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		throw new IllegalSelectorException();
	}

	public Reserved getReservation(int resNo) {
		Iterator<Reserved> iterator = getAll().iterator();
		while (iterator.hasNext()) {
			Reserved r = iterator.next();
			if (r.getResNo() == resNo) {
				return r;
			}
		}
		throw new IllegalArgumentException("No Reserved with that reservation number was found");
	}

	public void removeReservation(int resNo) throws RemoteException {
		Reserved r = getReservation(resNo);
		model.remove(r);
	}

	/**
	 * validates the input dates and asks the server for the information
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws RemoteException
	 */
	public ReservedList getAllInInterval(String startDate, String endDate) throws RemoteException {
		if (!validateDate(startDate) && !validateDate(endDate)) {
			throw new IllegalArgumentException("Date in invalid format!");
		}
		TheTime sDate = TheTime.convert(startDate);
		TheTime eDate = TheTime.convert(endDate);
		if (eDate.isBefore(sDate)) {
			throw new IllegalArgumentException("StartDate must be before endDate!");
		}
		ReservedList all = model.getAll();
		Iterator<Reserved> it = all.iterator();
		while (it.hasNext()) {
			Reserved next = it.next();
			TheTime pickUpTime = next.getPickUpTime();
			TheTime returnTime = next.getReturnTime();
			if (!pickUpTime.isBefore(eDate) || returnTime.isBefore(sDate)) {
				it.remove();
			}
		}
		return all;
	}

	@Override
	public void update(Object observable, Object updateMsg) throws RemoteException {
		view.update();
	}

	private boolean validateDate(String date) {
		Pattern pattern = Pattern.compile("\\d{1,2}/\\d{1,2}/\\d{4}");
		Matcher matcher = pattern.matcher(date);
		if (!matcher.matches()) {
			return false;
		}		
		return true;
	}

}
