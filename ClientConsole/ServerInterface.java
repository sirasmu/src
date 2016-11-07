package ClientConsole;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerInterface extends Remote
{
    String toUpperCase(String msg, Object client) 
                                      throws RemoteException;
}
