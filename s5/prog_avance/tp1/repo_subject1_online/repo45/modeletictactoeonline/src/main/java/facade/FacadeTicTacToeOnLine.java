package facade;

import exceptions.*;
import modele.*;

import java.util.Collection;

public interface FacadeTicTacToeOnLine {


    /**
     * Permet de créer une partie. Le pseudo de l'invité a une place réservée. IL suffit qu'il se connecte pour qu'il puisse accèder à la partie.
     * En gros le propriétéaire invite qqn à jouer.
     * @param proprietaire
     * @param invite
     * @throws PseudosIncorrectsException
     * @throws PseudoDejaUtiliseException
     */
    void creerPartie(String proprietaire, String invite) throws PseudosIncorrectsException, PseudoDejaUtiliseException;


    /**
     * L'invité rejoint une partie préalablement créée
     * @param invite
     * @throws PartieNonTrouveeException : pas de partie trouvée pour ce joueur
     * @throws DejaConnecteException
     */
    void rejoindre(String invite) throws PartieNonTrouveeException, DejaConnecteException;


    /**
     * Permet au joueur de jouer un coup en case x,y
     * @param joueur
     * @param x
     * @param y
     * @throws TricheurException
     * @throws CoupInvalideException
     * @throws CoupDejaJoueException
     * @throws PartieNonTrouveeException
     */
    void jouerCoup(String joueur, int x, int y) throws TricheurException, CoupInvalideException, CoupDejaJoueException, PartieNonTrouveeException;


    /**
     * Permet de savoir à qui est le tour de jouer.
     * @param joueur
     * @return
     * @throws PartieNonTrouveeException
     */
    String getJoueurCourant(String joueur) throws PartieNonTrouveeException;

    /**
     * Permet de récupérer le plateau de la partie où le joueur se trouve
     * @param joueur
     * @return
     * @throws PartieNonTrouveeException
     */

    Plateau getPlateau(String joueur) throws PartieNonTrouveeException;

    /**
     * Permet de savoir si la partie concernant le joueur en paramètre est terminée ou non
     * @param joueur
     * @return
     * @throws PartieNonTrouveeException
     */
    boolean isPartieTerminee(String joueur) throws PartieNonTrouveeException;


    /**
     * Permet de savoir qui est le gagnant s'il y en a un
     * @param joueur
     * @return
     * @throws PasDeGagnantException
     * @throws PartieNonTrouveeException
     */
    String getGagnant(String joueur) throws PasDeGagnantException, PartieNonTrouveeException;

    /**
     * Permet à un joueur de quitter la partie et donc d'abandonner la partie en cours si cette dernière n'était pas terminée
     * @param joueur
     * @throws PartieNonTrouveeException
     */
    void quitter(String joueur) throws PartieNonTrouveeException;


    /**
     * Permet de récupérer la liste des personnes connectées.
     * @return
     */
    Collection<String> getJoueursConnectes();
}
