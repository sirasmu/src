package ClientConsole;
	import java.rmi.Remote;
import java.rmi.RemoteException;

import WIP.data.*;

	public interface InterfaceModel extends Remote {
	     ReservedList getAll() throws RemoteException;
	}

