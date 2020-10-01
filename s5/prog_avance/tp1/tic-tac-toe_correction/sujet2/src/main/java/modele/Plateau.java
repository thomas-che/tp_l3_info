package modele;

import modele.exceptions.CaseDejaOccupeeException;
import modele.exceptions.CoupIncorrectException;
import modele.exceptions.EgaliteException;
import modele.exceptions.PartieNonTermineeException;

public interface Plateau {
    void jouer(int x, int y) throws CoupIncorrectException, CaseDejaOccupeeException, PartieTermineeException;

    boolean partieTerminee();

    void rejouerPartie();

    void quitter();

    String getGagnant() throws PartieNonTermineeException, EgaliteException;

    String getJoueurCourant();
}
