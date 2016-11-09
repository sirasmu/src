package ClientConsole;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import WIP.data.Reserved;
import WIP.data.ReservedFileAdapter;
import WIP.data.ReservedList;

/***
 * 
 * @author Adam This class is the Model Manager (I think).
 */
public class ModelManager extends UnicastRemoteObject implements InterfaceModel {
	// static final long serialVersionUID = 1L;
	private ReservedFileAdapter rfa;
	private ReservedList reservedList;

	public ModelManager() throws RemoteException {
		rfa = new ReservedFileAdapter("reservedList.bin");
		reservedList = rfa.getAll();
	}

	@Override
	public ReservedList getAll() throws RemoteException {
		return reservedList;
	}

	@Override
	public void removeBooking(Reserved reservation) throws RemoteException {
		reservedList.remove(reservation);
		rfa.saveReservations(reservedList);
	}
}