package sujet4.modele;

import sujet4.modele.exceptions.*;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Collection;

public interface FacadeMessagerie extends Remote {
    void inscription(String nom, String mdp) throws
            UtilisateurDejaExistantException,
            PseudoIncorrectException,
            RemoteException;

    void connexion(String nom, String mdp) throws
            UtilisateurInexistantException,
            UtilisateurDejaConnecteException,
            IdentifiantsIncorrectsException,
            RemoteException;

    void deconnexion(String nom) throws
                    UtilisateurNonConnecteException,
                    UtilisateurInexistantException,
            RemoteException;

    void resiliation(String nom, String mdp) throws
            IdentifiantsIncorrectsException,
            RemoteException;

    void creationDiscussion(String createur, String destinataire) throws
                            DiscussionDejaExistanteException,
                            DestinataireInconnuException,
                            UtilisateurInexistantException,
                            UtilisateurNonConnecteException,
            RemoteException;

    void envoyerMessage(String envoyeur, String destinataire,
                        String message) throws
                                    UtilisateurNonConnecteException,
                                    DestinataireInconnuException,
                                    MessageIncorrectException, UtilisateurInexistantException,
            RemoteException;

    Collection<Discussion> getDiscussion(String demandeur)
                                            throws UtilisateurNonConnecteException, UtilisateurInexistantException,
            RemoteException;
}
