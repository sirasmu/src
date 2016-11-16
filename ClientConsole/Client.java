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
	private int remotePort;
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	
	private Client(String remoteHostName, int remotePort) {
		this.remoteHostName = remoteHostName;
		this.remotePort = remotePort;
		connectToServer();
	}

	private void connectToServer() {
		String connectLocation = "//" + remoteHostName + ":" + remotePort + "/Connect";
		String in= null;
		try {
			System.out.println("Connecting to client at : " + connectLocation);
			InterfaceNameAndIP namemodel = (InterfaceNameAndIP) Naming.lookup(connectLocation);
			String[] list=namemodel.getAllNames();
			System.out.println(namemodel.getAllNames()[0]);
			System.out.println("The list: "+list);
			
			try {
				in = reader.readLine();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			String remoteHostName2 = namemodel.getIP(in);
			
			
			String connectLocation2 = "//" + remoteHostName2 + ":" + remotePort + "/Connect2";
			System.out.println("Connecting to client at : " + connectLocation2);
			InterfaceModel model = (InterfaceModel) Naming.lookup(connectLocation2);
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
		new Client("localhost", 1099);
		//ServerMenu();
		new Client("localhost", 1099);
	}
}
