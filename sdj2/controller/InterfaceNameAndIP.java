package sdj2.controller;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceNameAndIP extends Remote {

	String[] getAllNames() throws RemoteException;

	String getIP(String name) throws RemoteException;

}