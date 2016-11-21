package sdj2.controller;

import java.nio.channels.IllegalSelectorException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import SEP1.TheTime;
import sdj2.model.Rent;
import sdj2.model.RentList;
import sdj2.model.VehicleList;
import sdj2.view.ClientView;

public class ClientController extends UnicastRemoteObject implements RemoteObserver {

	private static final long serialVersionUID = -8573107128817026368L;
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
	public RentList getAll() {
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
	public Rent getReservation(int resNo) throws RemoteException {
		return model.getRent(resNo);
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

	public VehicleList getAllInInterval(String startDate, String endDate) throws RemoteException {
		if (!validateDate(startDate) && !validateDate(endDate)) {

			throw new IllegalArgumentException("Date in invalid format!");
		}
		TheTime sDate = TheTime.convert(startDate);
		TheTime eDate = TheTime.convert(endDate);
		if (eDate.isBefore(sDate)) {
			throw new IllegalArgumentException("StartDate must be before endDate!");
		}
		return model.getAllInInterval(sDate, eDate);
	}

	public boolean validateDate(String date) {
		Matcher match = datePattern.matcher(date);
		return match.matches();
	}

	@Override
	public void update(Object observable, Object updateMsg) throws RemoteException {
		view.update(updateMsg);
	}

	public void saveReservation(Rent r) {
		try {
			model.saveReservation(r);
		} catch (RemoteException e) {
			e.printStackTrace();
			System.out.println("Saving the reservation failed");
		}
	}
}