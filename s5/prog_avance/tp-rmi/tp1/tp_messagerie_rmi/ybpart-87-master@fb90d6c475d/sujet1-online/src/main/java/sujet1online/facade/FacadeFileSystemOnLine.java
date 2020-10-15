package sujet1online.facade;

import sujet1.modele.Composant;
import  sujet1.modele.exceptions.DossierDejaExistantException;
import  sujet1.modele.exceptions.DossierInexistantException;
import sujet1online.modele.Utilisateur;
import sujet1online.modele.exceptions.UtilisateurDejaExistantException;
import sujet1online.modele.exceptions.UtilisateurInexistantException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FacadeFileSystemOnLine {

    private Map<String, Utilisateur> lesUtilisateurs;


    public FacadeFileSystemOnLine() {
        this.lesUtilisateurs = new HashMap<>();
    }

    public void abonner(String nom) throws UtilisateurDejaExistantException {
        if (this.lesUtilisateurs.containsKey(nom)) {
            throw new UtilisateurDejaExistantException();
        }
        Utilisateur utilisateur = new Utilisateur(nom);
        this.lesUtilisateurs.put(nom,utilisateur);
    }


    public void desabonner(String nom)
    {
        this.lesUtilisateurs.remove(nom);
    }


    public void mkdir(String who, String nomDossier) throws
            DossierDejaExistantException, UtilisateurInexistantException {

        Utilisateur utilisateur = this.lesUtilisateurs.get(who);
        if (Objects.isNull(utilisateur)) {
            throw new UtilisateurInexistantException();
        }
        utilisateur.getFileSystem().mkdir(nomDossier);

    }


    public void cd(String who, String cible) throws UtilisateurInexistantException, DossierInexistantException {
        Utilisateur utilisateur = this.lesUtilisateurs.get(who);
        if (Objects.isNull(utilisateur)) {
            throw new UtilisateurInexistantException();
        }
        utilisateur.getFileSystem().cd(cible);


    }

    public Collection<Composant> ls(String who) throws UtilisateurInexistantException {
        Utilisateur utilisateur = this.lesUtilisateurs.get(who);
        if (Objects.isNull(utilisateur)) {
            throw new UtilisateurInexistantException();
        }
        return utilisateur.getFileSystem().ls();
    }

}
