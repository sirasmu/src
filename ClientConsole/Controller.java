package ClientConsole;

import java.nio.channels.IllegalSelectorException;
import java.rmi.RemoteException;
import java.util.Observable;
import java.util.Observer;

import WIP.data.ReservedList;

public class Controller implements Observer {
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

@Override
public void update(Observable o, Object arg) {
	String message=arg.toString();
	String reply="";
	String[] split = message.split(":");
	
	if (split.length != 2) {
		reply = "Wrong command";
	}
	else if(split[0].equalsIgnoreCase("Delete")){
		reply="A car was deleted";
	}
	else if(split[0].equalsIgnoreCase("Book")){
		reply="A car was booked";
	}
	
	System.out.println("Something changed: "+reply);
	
	
}
	
}

