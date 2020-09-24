package facade;

import module.Item;
import module.Utilisateur;
import module.execption.DejaPresentException;
import module.execption.NotFoundException;
import module.execption.UtilisateurDejaExistant;
import module.execption.UtilisateurInxistant;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FacadeOnline {

    private Map<String, Utilisateur> lesUtilisateur;

    public FacadeOnline() {
        this.lesUtilisateur = new HashMap<>();
    }

    public void abonner (String nom) throws UtilisateurDejaExistant {
        if (this.lesUtilisateur.containsKey(nom)){
            throw new UtilisateurDejaExistant();
        }
        Utilisateur utilisateur = new Utilisateur(nom);
        lesUtilisateur.put(nom,utilisateur);
    }

    public void desabonner (String nom){
        this.lesUtilisateur.remove(nom);
    }

    public void mkdir(String who, String nomDossier) throws DejaPresentException, UtilisateurInxistant {
        Utilisateur utilisateur = lesUtilisateur.get(who);
        if (Objects.isNull(utilisateur)){
            throw new UtilisateurInxistant();
        }
        utilisateur.getFileSys().creerDossier(nomDossier);
    }


    public void cd(String who, String cible) throws UtilisateurInxistant, NotFoundException {
        Utilisateur utilisateur = lesUtilisateur.get(who);
        if (Objects.isNull(utilisateur)){
            throw new UtilisateurInxistant();
        }
        utilisateur.getFileSys().cd(cible);
    }

    public Collection<Item> ls (String who) throws UtilisateurInxistant {
        Utilisateur utilisateur = lesUtilisateur.get(who);
        if (Objects.isNull(utilisateur)){
            throw new UtilisateurInxistant();
        }
        return utilisateur.getFileSys().ls();
    }



}
