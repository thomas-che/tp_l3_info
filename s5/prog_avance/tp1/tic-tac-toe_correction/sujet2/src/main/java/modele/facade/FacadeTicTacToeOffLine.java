package modele.facade;

import modele.PartieTermineeException;
import modele.Plateau;
import modele.exceptions.*;

public interface FacadeTicTacToeOffLine {

    /**
     * Permet de créer une partie
     * @param joueur1 : pseudo joueur 1
     * @param joueur2 : pseudo joueur 2
     * @throws PseudoIncorrectException : au moins l'un des deux pseudos
     * est incorrect (pseudo double ou vide)
     */
    void creerPartie(String joueur1, String joueur2) throws PseudoIncorrectException;

    /**
     * Permet au joueur courant de jouer
     * @param x : indice colonne compris entre 0 et 2
     * @param y : indice ligne compris entre 0 et 2
     * @throws CoupIncorrectException : les coordonnées ne sont pas correctes
     * @throws CaseDejaOccupeeException : les coordonées correspondent à une
     * case déjà jouée.
     *
     */
    void jouer(int x, int y) throws CoupIncorrectException,
            CaseDejaOccupeeException, PartieTermineeException;


    /**
     * Permet de savoir l'état de la partie
     * @return vrai si la partie est terminée et faux sinon
     */
    boolean partieTerminee();

    /**
     * Permet de réinitialiser la structure de donnée de la partie
     */

    void rejouerPartie();


    /**
     * Permet de quitter la partie en déclarant forfait
     */
    void quitter();


    /**
     * Permet de récupérer la structure de donnée représentant le morpion
     * @return le morpion
     */
    Plateau getPlateau();

    /**
     * Permet de récupérer le nom du gagnant si gagnant il y a
     * @return
     * @throws PartieNonTermineeException : la partie n'est pas terminée donc pas encore de gagnant
     * @throws EgaliteException : la partie est terminée mais personne n'a gagné
     */
    String getGagnant() throws PartieNonTermineeException, EgaliteException;


    /**
     * Permet de savoir à qui le tour de jouer
     * @return : nom du joueur courant
     */
    String getJoueurCourant();

}
