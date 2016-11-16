package ClientConsole;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

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
		try {
			adaptertxt = (Adapter_txt) adaptertxt.readFromFile("resources/server_address.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		adaptertxtMethods = new Adapter_txtMethods(adaptertxt);
	}

	@Override
	public String[] getAllNames() throws RemoteException{

		System.out.println(adaptertxtMethods.getAllNames()[0]);
		return adaptertxtMethods.getAllNames();
	}

	@Override
	public String getIP(String name) throws RemoteException{
		
		return adaptertxtMethods.getIPbyName(name);
	}
	
}
