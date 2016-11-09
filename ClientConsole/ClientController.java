package ClientConsole;

import java.nio.channels.IllegalSelectorException;
import java.rmi.RemoteException;

import WIP.data.ReservedList;
import WIP.data.Reserved;

import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import utility.observer.RemoteObserver;
import utility.observer.RemoteSubject;
import WIP.data.Reserved;
import WIP.data.ReservedList;


public class ClientController implements RemoteObserver {

	private InterfaceModel model;
	private Client client;

	public ClientController(InterfaceModel model) {
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
	
	public Reserved removeReservation(int resNo){
		Reserved r = getReservation(resNo);
		return getAll().remove(r);
	}

	@Override
	public void update(RemoteSubject arg0, Object arg1) throws RemoteException {
		client.update();
		
	}

	
}
