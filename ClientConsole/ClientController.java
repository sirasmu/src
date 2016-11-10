package ClientConsole;

import java.nio.channels.IllegalSelectorException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import WIP.data.Reserved;
import WIP.data.ReservedList;

public class ClientController extends UnicastRemoteObject implements RemoteObserver {

	private InterfaceModel model;
	private ClientView view;

	public ClientController(InterfaceModel model, ClientView view) throws RemoteException {
		this.model = model;
		this.view = view;
		model.addObserver(this);
		view.displayBookings();
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
		model.removeBooking(r);
	}

	/**
	 * validates the input dates and asks the server for the information
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public ReservedList getAllInInterval(String startDate, String endDate) {
		Pattern pattern = Pattern.compile("\\d{2}/\\d{2}/\\d{4}");
		Matcher mStart = pattern.matcher(startDate);
		Matcher mEnd = pattern.matcher(endDate);
		if (!mStart.matches() || !mEnd.matches()) {
			throw new IllegalArgumentException("Dates not valid format");
		}
		// return model.getAllInInterval(TheTime.convert(startDate),
		// TheTime.convert(endDate));
		return null;
	}

	@Override
	public void update(Object observable, Object updateMsg) throws RemoteException {
		view.update();
	}

}
