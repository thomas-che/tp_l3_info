package sujet2.modele;

import sujet2.modele.exceptions.CaseDejaOccupeeException;
import sujet2.modele.exceptions.CoupIncorrectException;
import sujet2.modele.exceptions.EgaliteException;
import sujet2.modele.exceptions.PartieNonTermineeException;

public interface Plateau {
    void jouer(int x, int y) throws CoupIncorrectException, CaseDejaOccupeeException, PartieTermineeException;

    boolean partieTerminee();

    void rejouerPartie();

    void quitter();

    String getGagnant() throws PartieNonTermineeException, EgaliteException;

    String getJoueurCourant();
}
