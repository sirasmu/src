package ClientConsole;

import java.nio.channels.IllegalSelectorException;
import java.rmi.RemoteException;
import WIP.data.ReservedList;
import WIP.data.Reserved;

public class Controller {
	private InterfaceModel model;

	public Controller(InterfaceModel model) {
		this.model = model;
	}

	public ReservedList getAll() {
		try {
			return model.getAll();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		throw new IllegalSelectorException();
	}
	
	public Reserved getReservation(int resNo){
		
		while(getAll().iterator().hasNext()){
			Reserved r = getAll().iterator().next();
			if(r.getResNo() == resNo){
				return r;
			}
		}
		throw new IllegalArgumentException("No Reserved with that reservation number was found");
	}
	
	public Reserved deleteReservation(int resNo){
		Reserved r = getReservation(resNo);
	}
}
