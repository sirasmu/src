package ClientConsole;

import java.rmi.Remote;
import java.rmi.RemoteException;
import WIP.data.ReservedList;
import WIP.data.Reserved;

public interface InterfaceModel extends Remote {

	public ReservedList getAll() throws RemoteException;

	public void deleteReservation(int resNo) throws RemoteException;

	public void addObserver(RemoteObserver o) throws RemoteException;

}
