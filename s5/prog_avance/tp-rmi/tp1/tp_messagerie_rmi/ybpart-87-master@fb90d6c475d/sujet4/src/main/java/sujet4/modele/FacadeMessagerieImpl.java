package sujet4.modele;

import sujet4.modele.exceptions.*;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.*;

public class FacadeMessagerieImpl implements FacadeMessagerie, Serializable {
    public static final int TAILLE_PSEUDO_MIN = 0;
    public static final int TAILLE_MDP_MIN = 0;
    private Map<String,Utilisateur> utilisateurs;
    private Collection<Utilisateur> utilisateursConnectes;

    public FacadeMessagerieImpl() {
        this.utilisateurs = new HashMap<>();
        this.utilisateursConnectes = new ArrayList<>();
    }


    private Utilisateur getUtilisateurParNom(String pseudo) throws UtilisateurInexistantException, RemoteException {
        if (!utilisateurs.containsKey(pseudo)) {
            throw new UtilisateurInexistantException();
        }
        else
            return utilisateurs.get(pseudo);
    }

    @Override
    public void inscription(String nom, String mdp) throws
            UtilisateurDejaExistantException,
            PseudoIncorrectException {
        try {
            this.getUtilisateurParNom(nom);
            throw new UtilisateurDejaExistantException();
        } catch (UtilisateurInexistantException | RemoteException e) {
            if (Objects.isNull(nom) ||
                    Objects.isNull(mdp) ||
                    nom.length()<= TAILLE_PSEUDO_MIN ||
                    mdp.length()<= TAILLE_MDP_MIN
            ) {
                throw new PseudoIncorrectException();
            }
            else {
                Utilisateur utilisateur = new Utilisateur(nom,mdp);
                this.utilisateurs.put(nom,utilisateur);
            }
        }
    }

    @Override
    public void connexion(String nom, String mdp) throws UtilisateurInexistantException, UtilisateurDejaConnecteException, IdentifiantsIncorrectsException, RemoteException {
        Utilisateur utilisateur = this.getUtilisateurParNom(nom);

        if (utilisateursConnectes.contains(utilisateur)) {
            throw new UtilisateurDejaConnecteException();
        }
        if (utilisateur.checkMdP(mdp)) {
            this.utilisateursConnectes.add(utilisateur);
        }
        else
            throw new IdentifiantsIncorrectsException();
    }

    @Override
    public void deconnexion(String nom) throws
            UtilisateurNonConnecteException,
            UtilisateurInexistantException, RemoteException {
        Utilisateur utilisateur = this.getUtilisateurParNom(nom);
        if (utilisateursConnectes.contains(utilisateur)) {
            utilisateursConnectes.remove(utilisateur);
        }
        else
            throw new UtilisateurNonConnecteException();
    }

    @Override
    public void resiliation(String nom, String mdp) throws IdentifiantsIncorrectsException {
        try {
            Utilisateur utilisateur = this.getUtilisateurParNom(nom);
            if (utilisateur.checkMdP(mdp)) {
                this.utilisateurs.remove(utilisateur);
                this.utilisateursConnectes.remove(utilisateur);
            }
            else
                throw new IdentifiantsIncorrectsException();
        } catch (UtilisateurInexistantException | RemoteException e) {
            throw new IdentifiantsIncorrectsException();
        }

    }

    @Override
    public void creationDiscussion(String createur, String destinataire) throws DiscussionDejaExistanteException,
            DestinataireInconnuException,
            UtilisateurInexistantException,
            UtilisateurNonConnecteException, RemoteException {
        Utilisateur cUtilisateur = this.getUtilisateurParNom(createur);
        if (!this.utilisateursConnectes.contains(cUtilisateur))
            throw new UtilisateurNonConnecteException();
        try {
            Utilisateur dUtilisateur = this.getUtilisateurParNom(destinataire);
            try {
                cUtilisateur.getDiscussion(dUtilisateur);
                throw new DiscussionDejaExistanteException();
            }
            catch (DiscussionInexistanteException e) {
                Discussion discussion =
                        new Discussion(cUtilisateur,dUtilisateur);
                cUtilisateur.ajouterDiscussion(discussion);
                dUtilisateur.ajouterDiscussion(discussion);
            }
        }
        catch (UtilisateurInexistantException e) {
            throw new DestinataireInconnuException();
        }

    }

    @Override
    public void envoyerMessage(String envoyeur, String destinataire,
                               String message) throws
            UtilisateurNonConnecteException,
            DestinataireInconnuException,
            MessageIncorrectException, UtilisateurInexistantException, RemoteException {
        Utilisateur utilisateur = this.getUtilisateurParNom(envoyeur);
        if (!this.utilisateursConnectes.contains(utilisateur)) {
            throw new UtilisateurNonConnecteException();
        }
        try {
            Utilisateur dest = this.getUtilisateurParNom(destinataire);
            try {
                Discussion discussion = utilisateur.getDiscussion(dest);
                discussion.ajouterMessage(new Message(utilisateur,message));
            } catch (DiscussionInexistanteException e) {
                try {
                    this.creationDiscussion(envoyeur,destinataire);
                    this.envoyerMessage(envoyeur, destinataire, message);
                } catch (DiscussionDejaExistanteException discussionDejaExistanteException) {

                }
            }
        }
        catch (UtilisateurInexistantException e) {
            throw new DestinataireInconnuException();
        }


    }

    @Override
    public Collection<Discussion> getDiscussion(String demandeur)
            throws UtilisateurNonConnecteException, UtilisateurInexistantException, RemoteException {
        Utilisateur utilisateur = this.getUtilisateurParNom(demandeur);
        if (!this.utilisateursConnectes.contains(utilisateur)) {
            throw new UtilisateurNonConnecteException();
        }

        return utilisateur.getDiscussions();
    }
}
