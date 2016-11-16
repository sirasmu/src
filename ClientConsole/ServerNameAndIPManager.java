package ClientConsole;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;

import WIP.data.utility.Adapter_txt;
import WIP.data.utility.Adapter_txtMethods;

public class ServerNameAndIPManager extends UnicastRemoteObject implements InterfaceNameAndIP {

	private String name;
	private String ip;
	private Adapter_txt adaptertxt;
	private Adapter_txtMethods adaptertxtMethods;
	
	public ServerNameAndIPManager() throws RemoteException 
	{
		adaptertxt = new Adapter_txt();
		adaptertxtMethods = new Adapter_txtMethods(adaptertxt,"resources/server_address.txt");
	}

	@Override
	public String[] getAllNames() throws RemoteException{
		return adaptertxtMethods.getAllNames();
	}

	@Override
	public String getIP(String name) throws RemoteException{
		
		return adaptertxtMethods.getIPbyName(name);
	}
	
}
