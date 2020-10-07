package programme;

import execption.*;
import facade.Facade;

public class Programme {
    public static void main(String[] args) {
        Facade facade = new Facade();

        try {
            facade.inscription("thomas","mon_mdp");
            facade.inscription("mathieu","mon_mdp");
            /*facade.inscription("thomas","mon_mdp");*/

            System.out.println("\n\n--------- test deco ---------");
            facade.deconnection("thomas");
            /*facade.deconnection("thomas");*/

            System.out.println("\n\n--------- test co ---------");
            facade.connection("thomas","mon_mdp");

            System.out.println("\n\n--------- test faux mdp ---------");
            facade.deconnection("thomas");
            /*facade.connection("thomas","mon_mdpzlegraliygl");*/

            System.out.println("\n\n--------- test cree discu ---------");
            facade.connection("thomas","mon_mdp");
            facade.creeDiscution("thomas","mathieu","test-discu-titre","le corps du message");

            System.out.println("\n\n--------- test cree discu avec faux user ---------");
            /*facade.creeDiscution("thomas","michel","test-discu-titre","le corps du message");*/

            System.out.println("\n\n--------- test cree discu en etant deco ---------");
            /*facade.deconnection("thomas");
            facade.creeDiscution("thomas","mathieu","test-discu-titre","le corps du message");*/

            System.out.println("\n\n--------- test cree discu deja existante ---------");
            /*facade.creeDiscution("thomas","mathieu","test-discu-titre","le corps du message");*/

            System.out.println("\n\n--------- test envoi msg ---------");
            facade.envoiMsg("thomas","mathieu","tu m as pas repondu :,(");

            System.out.println("\n\n--------- test envoi msg reponse ---------");
            facade.envoiMsg("mathieu","thomas","si je te repond");

            System.out.println("\n\n--------- test recup discu ---------");
            System.out.println(facade.recupererDiscussion("thomas") );


            System.out.println("\n\n--------- test recup discu si deco ---------");
            facade.deconnection("thomas");
            System.out.println(facade.recupererDiscussion("thomas") );


        }
        catch (Exception | ExceptionUtilisateurPasConnecter | ExceptionUtilisateurInexistant | ExceptionUtilisateurDejaConnecter | ExceptionDejaDiscussionEntreCesDeuxIndividu | ExceptionPasDeDiscussionEntreCesDeuxIndividu e){
            System.out.println("\n\tERROR : "+e.getMessage());
        }
    }
}
