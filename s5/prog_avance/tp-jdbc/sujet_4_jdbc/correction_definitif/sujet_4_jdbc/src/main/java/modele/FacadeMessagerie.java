package modele;

import modele.exceptions.*;

import java.util.Collection;

public interface FacadeMessagerie {
    void inscription(String nom, String mdp) throws
            UtilisateurDejaExistantException,
            PseudoIncorrectException;

    void connexion(String nom, String mdp) throws UtilisateurInexistantException, UtilisateurDejaConnecteException, IdentifiantsIncorrectsException;

    void deconnexion(String nom) throws
                    UtilisateurNonConnecteException,
                    UtilisateurInexistantException;

    void resiliation(String nom, String mdp) throws IdentifiantsIncorrectsException;

    void creationDiscussion(String createur, String destinataire) throws DiscussionDejaExistanteException,
                            DestinataireInconnuException,
                            UtilisateurInexistantException,
                            UtilisateurNonConnecteException;

    void envoyerMessage(String envoyeur, String destinataire,
                        String message) throws
                                    UtilisateurNonConnecteException,
                                    DestinataireInconnuException,
                                    MessageIncorrectException, UtilisateurInexistantException;

    Collection<Discussion> getDiscussion(String demandeur)
                                            throws UtilisateurNonConnecteException, UtilisateurInexistantException;
}
