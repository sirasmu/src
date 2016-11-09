package ClientConsole;

import java.rmi.Remote;
import java.rmi.RemoteException;
import WIP.data.ReservedList;
import WIP.data.Reserved;

public interface InterfaceModel extends Remote {

	ReservedList getAll() throws RemoteException;

	void removeBooking(Reserved reservation) throws RemoteException;

	void addObserver(RemoteObserver o) throws RemoteException;

}
