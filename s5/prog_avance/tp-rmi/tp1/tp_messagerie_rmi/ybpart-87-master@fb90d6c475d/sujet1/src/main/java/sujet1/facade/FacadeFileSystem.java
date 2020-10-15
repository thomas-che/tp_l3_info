package sujet1.facade;

import sujet1.modele.Composant;
import sujet1.modele.Dossier;
import sujet1.modele.exceptions.DossierDejaExistantException;
import sujet1.modele.exceptions.DossierInexistantException;

import java.util.Collection;

public class FacadeFileSystem {
    private Dossier dossierCourant;

    public FacadeFileSystem(String racine) {
        this.dossierCourant = new Dossier(null,
                racine);
    }

    public void mkdir(String dossier) throws DossierDejaExistantException {
        dossierCourant.mkdir(dossier);
    }

    public Collection<Composant> ls() {
        return dossierCourant.ls();
    }



    public void cd(String nomDossier) throws DossierInexistantException {
        this.dossierCourant = this.dossierCourant.cd(nomDossier);

    }



}
