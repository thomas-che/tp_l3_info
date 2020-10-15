package sujet1.modele;

import sujet1.modele.exceptions.DossierDejaExistantException;
import sujet1.modele.exceptions.DossierInexistantException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;


public class Dossier implements Composant {

    private String nom;
    private Dossier parent;
    private Collection<Dossier> lesDossiers;
    private Collection<Fichier> lesFichiers;

    public Dossier(Dossier dossier, String nom) {
        this.nom = nom;
        this.parent = dossier;
        lesDossiers = new ArrayList<>();
        lesFichiers = new ArrayList<>();
    }

    @Override
    public String getNom() {
        return nom;
    }

    public void mkdir(String dossier) throws DossierDejaExistantException {
        for(Dossier d : this.lesDossiers) {
            if (d.getNom().equals(dossier)) {
                throw new DossierDejaExistantException(dossier);
            }
        }

        this.lesDossiers.add(new Dossier(this,
                dossier));
    }

    public Collection<Composant> ls() {
        Collection<Composant> resultat = new ArrayList<>();
        resultat.addAll(this.lesDossiers);
        resultat.addAll(this.lesFichiers);
        return resultat;
    }

    public Dossier cd(String nomDossier) throws DossierInexistantException {

        if ("..".equals(nomDossier)) {
            if (Objects.isNull(parent)) {
                throw new DossierInexistantException("..");
            }
            return this.parent;
        }

        for (Dossier d : this.lesDossiers) {
            if (d.getNom().equals(nomDossier)) {
                return d;
            }
        }

        throw new DossierInexistantException(nomDossier);
    }
}
