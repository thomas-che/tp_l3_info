package programme;

import modele.DejaPresentException;
import modele.Item;
import modele.NotFoundException;
import module.User;

import java.util.List;

public class programme {
    public static void main(String[] args) throws DejaPresentException, NotFoundException {
        User user1 = new User("thomas");

        try {
            user1.getFacadeFileSys().creerDossier("doc1");
            user1.getFacadeFileSys().creerDossier("doc2");
            user1.getFacadeFileSys().creerDossier("doc3");
            /*System.out.println(user1.getFacadeFileSys().ls());*/
            List<Item> x = user1.getFacadeFileSys().ls();
            for (Item y : x) {
                System.out.print(y.getInfo() +"\n");
            }
            user1.getFacadeFileSys().cd("doc1");
            user1.getFacadeFileSys().creerDossier("dossier1");
            user1.getFacadeFileSys().creerFichier("fihier1","le contenut");
            System.out.println("\n ls dans le doc 1");
            List<Item> x2 = user1.getFacadeFileSys().ls();
            for (Item y2 : x2) {
                System.out.print(y2.getInfo() +"\n");
            }
        }
        catch (Exception e){
            System.err.println("<ERROR> "+e.getMessage() );
        }

    }
}
