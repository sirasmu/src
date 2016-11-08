package ClientConsole;
	import java.rmi.Remote;
import java.rmi.RemoteException;

import WIP.data.ReservedList;

	public interface Interface extends Remote {
	    public ReservedList Add() throws RemoteException;
	}

