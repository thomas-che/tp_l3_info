package serveur;

import interfaces.Hello;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class Lanceur {

    public static void main(String[] args) {

        // cree instance de hello
        Hello h = new HelloImpl();

        try{
            // 1) se co a annuaire
            Registry reg = LocateRegistry.getRegistry("localhost");

            // 2) preparer la classe pr l appel distant
            Hello hrem = (Hello)UnicastRemoteObject.exportObject(h,0);

            // 3) publier service
            reg.bind("HelloService",hrem);
            System.out.println("\nHello services publié....");

// initialiser l annuaire, metre le chemin complet vers le target/classes/
//            rmiregistry -J-Djava.rmi.server.codebase=file:///hod/o2180812/Documents/tp_l3/prog_avanced/tp_rmi/hello/target/classes/

            // 4) attendre msg client
            new Scanner(System.in).nextLine();

            // 5) arreter proprement le service
            System.out.println("FIN....");
            reg.unbind("HelloService");
            System.exit(0);
        }
        catch (RemoteException e){
            e.printStackTrace(); // excption du Registry
        } catch (AlreadyBoundException e) {
            e.printStackTrace(); // excption du bind()
        } catch (NotBoundException e) {
            e.printStackTrace(); // reg.unbind
        }
    }
}
