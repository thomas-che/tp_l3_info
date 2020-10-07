package facade;

import exceptions.*;
import modele.Discussion;

import java.util.Collection;

public interface FacadeMessagerieOnLine {

    static FacadeMessagerieOnLine creer() {
        return new FacadeMessagerieOnLineImpl();
    }

    /**
     * Un joueur peut s'inscrire si le pseudo est nouveau et le mot de passe non vide
     * @param identifiant
     * @param mdp
     * @throws PseudoDejaPrisException
     * @throws MauvaisFormatDonneesException
     */
    void inscription(String identifiant, String mdp) throws PseudoDejaPrisException, MauvaisFormatDonneesException;

    /**
     * Un joueur qui veut se désinscrire doit donner son mot de passe (la connexion n'est pas requise).
     * @param identifiant
     * @param mdp
     * @throws OperationNonAuthoriseeException
     */
    void desincription(String identifiant, String mdp) throws OperationNonAuthoriseeException;


    /**
     * Un joueur se connecte en utilisant ses données
     * @param identifiant
     * @param mdp
     * @throws PersonneDejaConnecteeException
     * @throws IdentificationException
     * @throws OperationNonAuthoriseeException
     */
    void connexion(String identifiant, String mdp) throws PersonneDejaConnecteeException, IdentificationException, OperationNonAuthoriseeException;

    /***
     * Un joueur se déconnecte
     * @param identifiant
     */
    void deconnexion(String identifiant);


    /**
     * Permet à l'utilisateur de récupérer une de ses discussions
     * @param identifiant
     * @param id
     * @return
     * @throws DiscussionNonTrouveeException
     * @throws OperationNonAuthoriseeException
     */
    Discussion getDiscussionById(String identifiant, long id) throws DiscussionNonTrouveeException, OperationNonAuthoriseeException;


    /**
     * Permet à l'utilisateur de récupérer l'ensemble de ses discussions
     * @param identifiant
     * @return
     * @throws OperationNonAuthoriseeException
     */

    Collection<Discussion> getAllDiscussions(String identifiant) throws OperationNonAuthoriseeException;


    /**
     * Permet à l'utilisateur d'envoyer un message sur une discussion existante.
     * @param identifiant
     * @param idDiscussion
     * @param message
     * @throws OperationNonAuthoriseeException
     * @throws DiscussionNonTrouveeException
     */
    void envoyerMessage(String identifiant, long idDiscussion, String message) throws OperationNonAuthoriseeException, DiscussionNonTrouveeException;

    /**
     * Permet de créer une discussion avec un individu inscrit à la plateforme
     * @param identifiant
     * @param destinataire
     * @throws OperationNonAuthoriseeException
     * @throws DestinataireInexistantException
     */
    void creerDiscussion(String identifiant, String destinataire) throws OperationNonAuthoriseeException, DestinataireInexistantException;

    /**
     * Permet de récupérer tous les gens inscrits (mais il faut être connecté)
     * @param identifiant
     * @return
     * @throws OperationNonAuthoriseeException
     */
    Collection<String> getAllPseudosInscrits(String identifiant) throws OperationNonAuthoriseeException;



}
