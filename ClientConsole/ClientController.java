package ClientConsole;

import java.nio.channels.IllegalSelectorException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import WIP.data.Reserved;
import WIP.data.ReservedList;
import WIP.data.utility.TheTime;

public class ClientController extends UnicastRemoteObject implements RemoteObserver {

	private InterfaceModel model;
	private ClientView view;
	private Pattern datePattern = Pattern.compile("\\d{1,2}/\\d{1,2}/\\d{4}");

	public ClientController(InterfaceModel model, ClientView view) throws RemoteException {
		this.model = model;
		this.view = view;
		view.addController(this);
		model.addObserver(this);
		view.displayMenu();
	}

	/**
	 * 
	 * @return a list of all reservations
	 */
	public ReservedList getAll() {
		try {
			return model.getAll();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		throw new IllegalSelectorException();
	}

	/**
	 * 
	 * @param resNo
	 *            number of the reservation
	 * @return a specific reservation
	 * @throws RemoteException
	 *             if there is a problem with the connection to the server
	 */
	public Reserved getReservation(int resNo) throws RemoteException {
		return model.getReservation(resNo);
	}

	/**
	 * deletes a specific reservation
	 * 
	 * @param resNo
	 *            number of the reservation to delete
	 * @throws RemoteException
	 *             if there is a problem with the connection to the server
	 */
	public void deleteReservation(int resNo) throws RemoteException {
		model.deleteReservation(resNo);
	}

	/**
	 * validates the input dates and asks the server for the reservations in the
	 * given interval
	 * 
	 * @param startDate
	 *            of the interval
	 * @param endDate
	 *            of the interval
	 * @return the reservations in a given interval
	 * @throws RemoteException
	 *             if there is a problem with the connection to the server
	 */
	public ReservedList getAllInInterval(String startDate, String endDate) throws RemoteException {
		Matcher startMatch = datePattern.matcher(startDate);
		Matcher endMatch = datePattern.matcher(endDate);
		if (!startMatch.matches() && !endMatch.matches()) {
			throw new IllegalArgumentException("Date in invalid format!");
		}
		TheTime sDate = TheTime.convert(startDate);
		TheTime eDate = TheTime.convert(endDate);
		if (eDate.isBefore(sDate)) {
			throw new IllegalArgumentException("StartDate must be before endDate!");
		}
		return model.getAllInInterval(sDate, eDate);
	}

	@Override
	public void update(Object observable, Object updateMsg) throws RemoteException {
		view.update(updateMsg);
	}

}
