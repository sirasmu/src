package ClientConsole;
	import java.rmi.Remote;
import java.rmi.RemoteException;

import WIP.data.ReservedList;

	public interface InterfaceModel extends Remote {
	     ReservedList getAll() throws RemoteException;
	}

