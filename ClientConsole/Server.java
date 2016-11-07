package ClientConsole;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements ServerInterface {
	public static void main(String[] args) {
		try {
			Registry reg = LocateRegistry.createRegistry(1099);
			ServerInterface rmiServer = new Server();
			Naming.rebind("toUppercase", rmiServer);
			System.out.println("Starting server...");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Server() throws RemoteException {
		super();
	}

	@Override
	public String toUpperCase(String msg, Object client) throws RemoteException {
		System.out.println("toUpperCase: client = " + client);
		return msg.toUpperCase();
	}

}
