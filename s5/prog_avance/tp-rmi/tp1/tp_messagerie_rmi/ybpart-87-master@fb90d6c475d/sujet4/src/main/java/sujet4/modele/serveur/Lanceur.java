package sujet4.modele.serveur;

import sujet4.modele.FacadeMessagerie;
import sujet4.modele.FacadeMessagerieImpl;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class Lanceur {
    public static void main(String[] args) {
        // cree instance de Facade messagerie
        FacadeMessagerie facade = new FacadeMessagerieImpl();

        try{
            // 1) se co a annuaire
            Registry reg = LocateRegistry.getRegistry("localhost");

            // 2) preparer la classe pr l appel distant
            FacadeMessagerie frem = (FacadeMessagerie) UnicastRemoteObject.exportObject(facade,0);

            // 3) publier service
            reg.bind("Messagerie",frem);
            System.out.println("\nMessagerie services publié....");

// initialiser l annuaire, metre le chemin complet vers le target/classes/
//            rmiregistry -J-Djava.rmi.server.codebase=file:////home/etud/o2180812/Documents/tp_l3/prog_avanced/tp_rmi/tp_modele_corr/ybpart-87-master@fb90d6c475d/sujet4/target/classes/

            // 4) attendre msg client
            new Scanner(System.in).nextLine();

            // 5) arreter proprement le service
            System.out.println("FIN....");
            reg.unbind("Messagerie");
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
