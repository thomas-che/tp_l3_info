package programme;

import modele.Composant;
import modele.exceptions.DossierDejaExistantException;
import modele.exceptions.DossierInexistantException;
import facade.FacadeFileSystem;

public class Programme {

    public static void main(String[] args) {
        FacadeFileSystem facadeFileSystem =
                new FacadeFileSystem("/");

        try {
            facadeFileSystem.mkdir("dossier1");
            facadeFileSystem.mkdir("dossier2");
            facadeFileSystem.cd("dossier2");
            facadeFileSystem.mkdir("dossier3");
            for(Composant c : facadeFileSystem.ls()) {
                System.out.println(c.getNom());
            }

            facadeFileSystem.cd("..");

            for(Composant c : facadeFileSystem.ls()) {
                System.out.println(c.getNom());
            }

            facadeFileSystem.cd("..");
            for(Composant c : facadeFileSystem.ls()) {
                System.out.println(c.getNom());
            }


        } catch (DossierDejaExistantException  e) {
            System.err.println("Soucis de création avec le dossier "+
                    e.getNomDossierProblematique());
        }

        catch (DossierInexistantException e) {
            System.err.println("Soucis destination inexistante : "+
                    e.getNomDossierProblematique());
        }

    }

}
