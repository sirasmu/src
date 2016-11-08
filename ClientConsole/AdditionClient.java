package ClientConsole;

import java.net.MalformedURLException;
import java.rmi.*;

import WIP.data.ReservedList;

public class AdditionClient {
    public static void main(String[] args) {
        String remoteHostName = "10.52.226.111";
        int remotePort = 1099;
        String connectLocation = "//" + remoteHostName + ":" + remotePort
                + "/Hello";

        AdditionalInterface hello = null;
        try {
            System.out.println("Connecting to client at : " + connectLocation);
            hello = (AdditionalInterface) Naming.lookup(connectLocation);
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
            result = hello.Add();
        } catch (RemoteException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        System.out.println("Result is :" + result);

    }
}
