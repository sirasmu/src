package ClientConsole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {

	private String remoteHostName;

	private int remotePortServer, remotePortDirectory;
	private BufferedReader reader = new BufferedReader(new InputStreamReader(
			System.in));

	private Client(String remoteHostName, int remotePortServer,
			int remotePortDirectory) {
		this.remoteHostName = remoteHostName;
		this.remotePortServer = remotePortServer;
		this.remotePortDirectory = remotePortDirectory;
		connectToServer();
	}

	private void connectToServer() {
		String connectLocation = "//" + remoteHostName + ":"
				+ remotePortDirectory + "/DirectoryServer";
		String in = null;
		try {
			System.out.println("Connecting to the directory server at: "
					+ connectLocation);

			InterfaceNameAndIP namemodel = (InterfaceNameAndIP) Naming
					.lookup(connectLocation);
			String[] list = namemodel.getAllNames();

			System.out.println("\nSelect a main server from the list: ");

			StringBuffer result = new StringBuffer();
			for (int i = 0; i < list.length; i++) {
				result.append(list[i] + "\n");
			}
			String mynewstring = result.toString();
			System.out.println(mynewstring);
			System.out.println("Type the name of the chosen server: ");
			try {
				in = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			String remoteHostName2 = namemodel.getIP(in);

			String connectLocation2 = "//" + remoteHostName2 + ":"
					+ remotePortServer + "/MainServer";
			System.out.println("Connecting to the main server at: "
					+ connectLocation2);
			InterfaceModel model = (InterfaceModel) Naming
					.lookup(connectLocation2);
			new ClientController(model, new ClientView());
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		} catch (NotBoundException e1) {
			e1.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Client("localhost", 1099, 1098);
	}
}
