package sujet3.facade;

import sujet2.modele.PartieTermineeException;
import sujet2.modele.Plateau;
import sujet3.modele.*;
import sujet2.modele.exceptions.*;

public interface FacadeTicTacToeOnLine {


    String creerPartie(String joueur1) throws
            PseudoIncorrectException,
            PseudoDejaDansUnePartieException;

    void rejoindrePartie(String joueur2,String jeton)
            throws PartieInexistanteException,
            PseudoIncorrectException,
            PseudoDejaDansUnePartieException;

    /**
     * Permet au joueur courant de jouer
     * @param x : indice colonne compris entre 0 et 2
     * @param y : indice ligne compris entre 0 et 2
     * @throws CoupIncorrectException : les coordonnées ne sont pas correctes
     * @throws CaseDejaOccupeeException : les coordonées correspondent à une
     * case déjà jouée.
     *
     */
    void jouer(String nomJoueur, int x, int y) throws CoupIncorrectException,
            CaseDejaOccupeeException, PartieInexistanteException,
            PasVotreTourException, PartieTermineeException;


    /**
     * Permet de savoir l'état de la partie
     * @return vrai si la partie est terminée et faux sinon
     */
    boolean partieTerminee(String nomJoueur) throws PartieInexistanteException;



    /**
     * Permet de quitter la partie en déclarant forfait
     */
    void quitter(String nomJoueur) throws PartieInexistanteException;


    /**
     * Permet de récupérer la structure de donnée représentant le morpion
     * @return le morpion
     */
    Plateau getPlateau(String nomJoueur) throws PartieInexistanteException;

    /**
     * Permet de récupérer le nom du gagnant si gagnant il y a
     * @return
     * @throws PartieNonTermineeException : la partie n'est pas terminée donc pas encore de gagnant
     * @throws EgaliteException : la partie est terminée mais personne n'a gagné
     */
    String getGagnant(String nomJoueur) throws
            PartieNonTermineeException,
            EgaliteException,
            PartieInexistanteException;


    /**
     * Permet de savoir à qui le tour de jouer
     * @return : nom du joueur courant
     */
    String getJoueurCourant(String nomJoueur) throws
            PartieInexistanteException;



}
