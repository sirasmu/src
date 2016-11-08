package ClientConsole;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import WIP.data.ReservedList;

public class Show extends UnicastRemoteObject implements
        Interface {
    private static final long serialVersionUID = 1L;

    public Show() throws RemoteException {
        // TODO Auto-generated constructor stub
    }

   

	@Override
	public ReservedList Add() throws RemoteException {
		
		return showReservations.callTestReservedFileAdapter();
	}
}