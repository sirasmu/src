package ClientConsole;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {

	private String remoteHostName;
	private int remotePort;

	public static void main(String[] args) {
		new Client("localhost", 1099);
		//ServerMenu();
		new Client("localhost", 1099);
	}

	private Client(String remoteHostName, int remotePort) {
		this.remoteHostName = remoteHostName;
		this.remotePort = remotePort;
		connectToServer();
	}

	private void connectToServer() {
		String connectLocation = "//" + remoteHostName + ":" + remotePort + "/Connect";
		try {
			System.out.println("Connecting to client at : " + connectLocation);
			InterfaceModel model = (InterfaceModel) Naming.lookup(connectLocation);
			new ClientController(model, new ClientView());
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		} catch (NotBoundException e1) {
			e1.printStackTrace();
		}
	}
}
