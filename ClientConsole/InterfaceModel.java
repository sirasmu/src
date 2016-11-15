package ClientConsole;

import java.rmi.Remote;
import java.rmi.RemoteException;

import SEP1.Rent;
import SEP1.RentList;
import SEP1.TheTime;


public interface InterfaceModel extends Remote {

	RentList getAll() throws RemoteException;

	void deleteReservation(int resNo) throws RemoteException;
	
	void addObserver(RemoteObserver o) throws RemoteException;

	Rent getResNo(int resNo) throws RemoteException;

	RentList getAllInInterval(TheTime startDate, TheTime endDate) throws RemoteException;
	
	void saveReservation(Rent reservation) throws RemoteException;
	
}
