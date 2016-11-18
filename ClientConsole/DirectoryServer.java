package ClientConsole;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class DirectoryServer {

	public static void main(String[] args) throws RemoteException,
			AlreadyBoundException, NotBoundException {

		ServerNameAndIPManager nameAndIpMan = new ServerNameAndIPManager();

		int port = 1098;

		try { // special exception handler for registry creation
			LocateRegistry.createRegistry(port);
			System.out.println("Java RMI registry created.");
		} catch (RemoteException e) {
			// do nothing, error means registry already exists
			System.out.println("Java RMI registry already exists.");
		}

		String hostname = "10.52.236.171";
		String bindLocation = "//" + hostname + ":" + port + "/DirectoryServer";

		bindLocationAndModel(bindLocation, nameAndIpMan);

	}

	public static void bindLocationAndModel(String location,
			ServerNameAndIPManager nameAndIpMan) {
		try {
			Naming.bind(location, nameAndIpMan);
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
