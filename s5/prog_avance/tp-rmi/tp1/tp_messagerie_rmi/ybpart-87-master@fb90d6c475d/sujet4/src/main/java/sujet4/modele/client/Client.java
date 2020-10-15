package sujet4.modele.client;

import sujet4.modele.FacadeMessagerie;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) throws RemoteException, NotBoundException {

        Registry reg = LocateRegistry.getRegistry("192.168.46.41");
        FacadeMessagerie facade = (FacadeMessagerie) reg.lookup("MailService"); //Messagerie

        try {
            facade.inscription("thomas2","thomas");
            /*facade.inscription("mathieu","mathieu");*/

            facade.connexion("Mathieu","xxxx");
            facade.creationDiscussion("Mathieu","thomas2");

        }
        catch (Exception e){
            e.printStackTrace();
        }




    }
}
