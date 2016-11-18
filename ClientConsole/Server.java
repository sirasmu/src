package ClientConsole;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import WIP.data.utility.Adapter_txt;
import WIP.data.utility.Adapter_txtMethods;

public class Server {
	public static void main(String[] args) throws RemoteException,
			AlreadyBoundException, NotBoundException {

		ModelManager show = new ModelManager();

		int port = 1099;

		try { // special exception handler for registry creation
			LocateRegistry.createRegistry(port);
			System.out.println("Java RMI registry created.");
		} catch (RemoteException e) {
			// do nothing, error means registry already exists
			System.out.println("Java RMI registry already exists.");
		}

		String hostname2 ="10.52.236.171";
		String bindLocation2 = "//" + hostname2 + ":" + port + "/MainServer";

		bindLocationAndModel2(bindLocation2, show);

	}

	public static void bindLocationAndModel2(String location, ModelManager model) {
		try {
			Naming.bind(location, model);
			System.out.println("The servers are ready at: " + location);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Server failed: " + e);
		}
	}

}