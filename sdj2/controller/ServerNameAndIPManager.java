package sdj2.controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import sdj2.model.Adapter_txt;
import sdj2.model.Adapter_txtMethods;

public class ServerNameAndIPManager extends UnicastRemoteObject implements InterfaceNameAndIP {

	private static final long serialVersionUID = 2769231433214049564L;
	private Adapter_txt adaptertxt;
	private Adapter_txtMethods adaptertxtMethods;

	public ServerNameAndIPManager() throws RemoteException {
		adaptertxt = Adapter_txt.getInstance();
		adaptertxtMethods = new Adapter_txtMethods(adaptertxt, "resources/server_address.txt");
	}

	@Override
	public String[] getAllNames() throws RemoteException {
		return adaptertxtMethods.getAllNames();
	}

	@Override
	public String getIP(String name) throws RemoteException {
		return adaptertxtMethods.getIPbyName(name);
	}
}