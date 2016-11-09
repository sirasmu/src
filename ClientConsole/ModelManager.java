package ClientConsole;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Observable;
import java.util.Observer;

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

	@Override
	public void addObserver(RemoteObserver o) throws RemoteException {
		reservedList.addObserver(new WrappedObserver(o));
	}

	private class WrappedObserver implements Observer, Serializable {

		private static final long serialVersionUID = 1L;

		private RemoteObserver ro = null;

		public WrappedObserver(RemoteObserver ro) {
			this.ro = ro;
		}

		@Override
		public void update(Observable o, Object arg) {
			try {
				ro.update(o.toString(), arg);
			} catch (RemoteException e) {
				System.out
						.println("Remote exception removing observer:" + this);
				o.deleteObserver(this);
			}
		}

	}
}