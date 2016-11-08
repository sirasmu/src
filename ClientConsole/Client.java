package ClientConsole;

import java.net.MalformedURLException;
import java.rmi.*;

import WIP.data.ReservedList;

public class Client {
    public static void main(String[] args) {
        String remoteHostName = "10.52.236.164";
        int remotePort = 1099;
        String connectLocation = "//" + remoteHostName + ":" + remotePort
                + "/Connect";

        Interface show = null;
        try {
            System.out.println("Connecting to client at : " + connectLocation);
            show = (Interface) Naming.lookup(connectLocation);
        } catch (MalformedURLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (RemoteException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (NotBoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        ReservedList result = null;
        try {
            result = show.Add();
        } catch (RemoteException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        System.out.println("Result is :" + result);

    }
}
