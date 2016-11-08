package ClientConsole;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import WIP.data.ReservedFileAdapter;
import WIP.data.ReservedList;

public class showReservations extends UnicastRemoteObject{
	protected showReservations() throws RemoteException {
		super();
		
	}
	
	public static ReservedList callTestReservedFileAdapter()
	{
		ReservedFileAdapter rfa = new ReservedFileAdapter("reservedList.bin");
		ReservedList reservedList = rfa.getAllReserveds();
		return reservedList;
		
	}
}