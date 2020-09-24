package modele;

import exceptions.CoupDejaJoueException;
import exceptions.CoupInvalideException;
import exceptions.PasDeGagnantException;

public interface Plateau {
    static Plateau creerPlateau() {
        return new PlateauImpl();
    }

    void ajouterCoup(int indiceJoueurCourant, int x, int y) throws CoupInvalideException, CoupDejaJoueException;

    boolean isTerminee();

    int getGagnant() throws PasDeGagnantException;
}
