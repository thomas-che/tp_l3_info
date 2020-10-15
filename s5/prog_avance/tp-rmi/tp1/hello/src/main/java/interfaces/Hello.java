package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote {

    /*String hello() throws RemoteException;*/

    Message hello() throws RemoteException;

}
