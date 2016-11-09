package ClientConsole;

import java.io.Serializable;
import java.nio.channels.IllegalSelectorException;
import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import SEP1.TheTime;
import WIP.data.Reserved;
import WIP.data.ReservedList;

public class ClientController implements RemoteObserver, Serializable {

	private InterfaceModel model;
	private transient Client client;

	public ClientController(InterfaceModel model, Client client) throws RemoteException {
		this.model = model;
		this.client = client;
		model.addObserver(this);
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
		throw new IllegalArgumentException(
				"No Reserved with that reservation number was found");
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
	public void update(Object observable, Object updateMsg)
			throws RemoteException {
		client.update();

	}

}
