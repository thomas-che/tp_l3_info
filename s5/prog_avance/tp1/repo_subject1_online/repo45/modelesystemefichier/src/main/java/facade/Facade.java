package facade;

import modele.*;

import java.util.List;

public class Facade {

    Dossier dossierCourant;
    Dossier racine;


    public Facade() {

        racine = new Dossier("/",null);
        dossierCourant = racine;
    }



    public void renommer(String courant, String next) throws RenommageImpossible {
        dossierCourant.renommer(courant,next);
    }

    public void creerDossier(String nom) throws DejaPresentException {
        Dossier nouveau = new Dossier(nom,dossierCourant);
        dossierCourant.addItem(nouveau);

    }

    public void creerFichier(String nom, String contenu) throws DejaPresentException {
        Fichier fichier = new Fichier(nom,contenu);
        dossierCourant.addItem(fichier);
    }



    public List<Item> ls() {
        return dossierCourant.ls();
    }



    public void cd(String nom) throws NotFoundException {
        if (nom.equals("..")) {
            dossierCourant = dossierCourant.getPere();
        }
        else {

            dossierCourant = dossierCourant.cd(nom);
        }
    }
}
