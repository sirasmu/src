package ClientConsole;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] argv) throws RemoteException {
        
    	ModelManager show = new ModelManager();
        int port = 1099;

        try { // special exception handler for registry creation
            LocateRegistry.createRegistry(port);
            System.out.println("java RMI registry created.");
        } catch (RemoteException e) {
            // do nothing, error means registry already exists
            System.out.println("java RMI registry already exists.");
        }

        String hostname = "10.52.237.2";
        String bindLocation = "//" + hostname + ":" + port + "/Connect";
        
        try {
            Naming.bind(bindLocation, show);    
            System.out.println("Server is ready at:" + bindLocation);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Server failed: " + e);
        }
    }
}