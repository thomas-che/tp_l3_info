package modele;

import sujet4.modele.exceptions.DiscussionInexistanteException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Utilisateur {
    private String nom;
    private String mdp;
    private Map<Utilisateur,Discussion> discussions;


    public Utilisateur(String nom, String mdp) {
        this.nom = nom;
        this.mdp = mdp;
        this.discussions = new HashMap<>();
    }


    public String getNom() {
        return nom;
    }


    public boolean checkMdP(String mdp) {
        return this.mdp.equals(mdp);
    }

    public Discussion getDiscussion(Utilisateur dUtilisateur)
            throws DiscussionInexistanteException {
        if (this.discussions.containsKey(dUtilisateur)) {
            return this.discussions.get(dUtilisateur);
        }
        else
            throw new DiscussionInexistanteException();
    }

    public void ajouterDiscussion(Discussion discussion) {
        Utilisateur destinataire =
                discussion.getUtilisateur1().equals(this)?
                discussion.getUtilisateur2(): discussion.getUtilisateur1();
        this.discussions.put(destinataire,discussion);
    }

    public Collection<Discussion> getDiscussions() {
        return this.discussions.values();
    }
}
