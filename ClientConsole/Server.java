package ClientConsole;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import package1.Adapter_txt;
import package1.Adapter_txtMethods;

public class Server {
	public static void main(String[] argv) throws RemoteException {

		ModelManager show = new ModelManager();
		int port = 1099;
		Adapter_txt ip_list = null;
		Adapter_txtMethods adpModule = new Adapter_txtMethods();

		try { // special exception handler for registry creation
			LocateRegistry.createRegistry(port);
			System.out.println("java RMI registry created.");
		} catch (RemoteException e) {
			// do nothing, error means registry already exists
			System.out.println("java RMI registry already exists.");
		}

		String hostname = "localhost";
		String bindLocation = "//" + hostname + ":" + port + "/Connect";

		ip_list = adpModule.loadList(ip_list, "server_address.txt");
		System.out.println(ip_list.showIpAddress().get(0)[1]);
		//ip_list.showIpAddress().get(0)[1];

		bindLocationAndModel(bindLocation, show);
		
		String bindLocation2 = "//" + ip_list.showIpAddress().get(0)[1] + ":" + port + "/Connect";
		//bindLocationAndModel(bindLocation2, show);

	}
	
	public static void bindLocationAndModel(String location, ModelManager model){
		try {
			Naming.bind(location, model);
			System.out.println("Servers are ready at:" + location);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Server failed: " + e);
		}
	}

}