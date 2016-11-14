package ClientConsole;

import java.rmi.Remote;
import java.rmi.RemoteException;
import WIP.data.ReservedList;
import WIP.data.utility.TheTime;
import WIP.data.Reserved;

public interface InterfaceModel extends Remote {

	ReservedList getAll() throws RemoteException;

	void deleteReservation(int resNo) throws RemoteException;
	
	void addObserver(RemoteObserver o) throws RemoteException;

	Reserved getReservation(int resNo) throws RemoteException;

	ReservedList getAllInInterval(TheTime startDate, TheTime endDate) throws RemoteException;
	
}
