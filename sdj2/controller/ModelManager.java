package sdj2.controller;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import sdj2.model.Rent;
import sdj2.model.RentList;
import sdj2.model.Vehicle;
import sdj2.model.VehicleList;
import sdj2.model.collection.LinkedSet;
import sdj2.model.collection.SetADT;
import sdj2.model.date.TheTime;
import sdj2.model.utility.RentFileAdapter;

/***
 * 
 * @author Adam This class is the Model Manager (I think).
 */
public class ModelManager extends UnicastRemoteObject implements InterfaceModel {

	private static final long serialVersionUID = 3640427338308620453L;
	private RentFileAdapter rfa;
	private RentList rentList;

	public ModelManager() throws RemoteException {
		rfa = new RentFileAdapter("resources/rentals.bin");
		rentList = rfa.getAllRents();
	}

	@Override
	public RentList getAll() throws RemoteException {
		return rentList;
	}

	@Override
	public void deleteReservation(int resNo) throws RemoteException {
		Rent reservation = getRent(resNo);
		rentList.remove(reservation);
		rfa.saveRents(rentList);
	}

	@Override
	public void addObserver(RemoteObserver o) throws RemoteException {
		rentList.addObserver(new WrappedObserver(o));
	}

	@Override
	public Rent getRent(int resNo) {
		Iterator<Rent> iterator = rentList.iterator();
		while (iterator.hasNext()) {
			Rent r = iterator.next();
			if (r.getResNo() == resNo) {
				return r;
			}
		}
		throw new IllegalArgumentException("No Reservation with that reservation number was found");
	}

	@Override
	public VehicleList getAllInInterval(TheTime startDate, TheTime endDate) {
		RentList result = new RentList(rentList.getAll());
		SetADT<Vehicle> vehicles = new LinkedSet<Vehicle>();
		Iterator<Rent> it = result.iterator();
		while (it.hasNext()) {
			Rent next = it.next();
			TheTime pickUpTime = next.getPickUpTime();
			TheTime returnTime = next.getReturnTime();
			if (!(!pickUpTime.isBefore(endDate) || returnTime.isBefore(startDate))) {
				vehicles.add(next.getVehicle());
			}
		}
		VehicleList list = new VehicleList();
		vehicles.forEach(v -> {
			list.add(v);
		});
		return list;
	}

	private class WrappedObserver implements Observer, Serializable {

		private static final long serialVersionUID = 1L;

		private RemoteObserver ro = null;

		public WrappedObserver(RemoteObserver ro) {
			this.ro = ro;
		}

		@Override
		public void update(Observable o, Object arg) {
			try {
				ro.update(o.toString(), arg);
			} catch (RemoteException e) {
				System.out.println("Remote exception removing observer:" + this);
				o.deleteObserver(this);
			}
		}
	}

	@Override
	public void saveReservation(Rent r) throws RemoteException {
		Rent temp = getRent(r.getResNo());
		temp.setFirstName(r.getFirstName());
		temp.setLastName(r.getLastName());
		temp.setPickUpTime(r.getPickUpTime());
		if (r.getReturnTime().isBefore(r.getPickUpTime())) {
			throw new IllegalArgumentException("The return time cannot be before the pick-up time.");
		}
		temp.setReturnTime(r.getReturnTime());
		rfa.saveRents(rentList);
	}
}