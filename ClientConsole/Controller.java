package ClientConsole;

import java.nio.channels.IllegalSelectorException;
import java.rmi.RemoteException;

import WIP.data.ReservedList;

public class Controller {
private InterfaceModel model;
public Controller(InterfaceModel model)
{
	this.model=model;
}

public ReservedList getAllReservation()
{
	try {
		return model.getAll();
	} catch (RemoteException e) {
		e.printStackTrace();
	}
	throw new IllegalSelectorException();
}
}
