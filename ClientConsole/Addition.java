package ClientConsole;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import WIP.data.ReservedList;

public class Addition extends UnicastRemoteObject implements
        AdditionalInterface {
    private static final long serialVersionUID = 1L;

    public Addition() throws RemoteException {
        // TODO Auto-generated constructor stub
    }

   

	@Override
	public ReservedList Add() throws RemoteException {
		
		return showReservations.callTestReservedFileAdapter();
	}
}