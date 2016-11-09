package ClientConsole;

import java.nio.channels.IllegalSelectorException;
import java.rmi.RemoteException;
import java.util.Iterator;

import WIP.data.*;

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
		
		Iterator<Reserved> iterator = getAll().iterator();
		while(iterator.hasNext()){
			Reserved r = iterator.next();
			if(r.getResNo() == resNo){
				return r;
			}
		}
		throw new IllegalArgumentException("No Reserved with that reservation number was found");
	}
}
