package programme;

import facade.FacadeOnline;
import module.Item;

import java.util.Collection;

public class Programme {
    public static void main(String[] args) {
        FacadeOnline facadeOnline = new FacadeOnline();
        String utilisateur1 = "Thomas";
        String utilisateur2 = "Mathieu";

        try {
            facadeOnline.abonner(utilisateur1);
            facadeOnline.abonner(utilisateur2);

            facadeOnline.mkdir(utilisateur1,"Doc1");
            facadeOnline.mkdir(utilisateur1,"Doc2");

            Collection<Item> x = facadeOnline.ls(utilisateur1);
            for (Item y : x) {
                System.out.print(y.getInfo() +"\n");
            }

            System.out.println("-----");

            facadeOnline.mkdir(utilisateur2,"Dossier1");
            facadeOnline.mkdir(utilisateur2,"Dossier2");
            facadeOnline.cd(utilisateur2,"Dossier1");
            facadeOnline.mkdir(utilisateur2,"sous-doc1");

            Collection<Item> x2 = facadeOnline.ls(utilisateur2);
            for (Item y2 : x2) {
                System.out.print(y2.getInfo() +"\n");
            }


        }
        catch (Exception e){
            System.err.println("<ERROR> "+e.getMessage() );
        }

    }
}
