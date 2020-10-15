package sujet1online.programme;

import sujet1online.facade.FacadeFileSystemOnLine;
import sujet1.modele.Composant;
import sujet1.modele.exceptions.DossierDejaExistantException;
import sujet1.modele.exceptions.DossierInexistantException;
import sujet1online.modele.exceptions.UtilisateurDejaExistantException;
import sujet1online.modele.exceptions.UtilisateurInexistantException;

import java.util.Collection;

public class Programme {


    public static void main(String[] args) throws UtilisateurDejaExistantException, DossierDejaExistantException, UtilisateurInexistantException, DossierInexistantException {

        FacadeFileSystemOnLine facadeFileSystemOnLine = new FacadeFileSystemOnLine();
        String utilisateur1= "Yohan";
        String utilisateur2 = "Fred";

        facadeFileSystemOnLine.abonner(utilisateur1);
//        facadeFileSystemOnLine.abonner(utilisateur1);

       // facadeFileSystemOnLine.mkdir(utilisateur2,"dossier1");
        facadeFileSystemOnLine.mkdir(utilisateur1,"dossier1");
        Collection<Composant> composants = facadeFileSystemOnLine.ls(utilisateur1);

        for(Composant composant : composants) {
            System.out.println(composant.getNom());
        }


        System.out.println("LS de Fred");
        facadeFileSystemOnLine.abonner(utilisateur2);
        composants = facadeFileSystemOnLine.ls(utilisateur2);

        for(Composant composant : composants) {
            System.out.println(composant.getNom());
        }
        System.out.println("-----");


        facadeFileSystemOnLine.cd(utilisateur1,"dossier1");
        facadeFileSystemOnLine.mkdir(utilisateur1,"dossier2");

        System.out.println("LS dans dossier1 de Yohan");

        composants = facadeFileSystemOnLine.ls(utilisateur1);

        for(Composant composant : composants) {
            System.out.println(composant.getNom());
        }
        System.out.println("-----");

        facadeFileSystemOnLine.cd(utilisateur1,"..");

        System.out.println("LS dans / de Yohan");

        composants = facadeFileSystemOnLine.ls(utilisateur1);

        for(Composant composant : composants) {
            System.out.println(composant.getNom());
        }
        System.out.println("-----");


    }

}
