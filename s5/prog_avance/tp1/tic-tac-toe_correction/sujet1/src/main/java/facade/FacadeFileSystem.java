package facade;

import modele.Composant;
import modele.Dossier;
import modele.exceptions.DossierDejaExistantException;
import modele.exceptions.DossierInexistantException;

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
