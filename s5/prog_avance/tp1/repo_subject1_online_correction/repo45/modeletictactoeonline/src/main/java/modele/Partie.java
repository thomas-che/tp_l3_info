package modele;

import exceptions.CoupDejaJoueException;
import exceptions.CoupInvalideException;
import exceptions.PasDeGagnantException;
import exceptions.TricheurException;

public interface Partie {
    static Partie creerPartie(String proprietaire, String invite) {
        return new PartieImpl(proprietaire,invite);
    }

    void jouerCoup(String joueur, int x, int y) throws TricheurException, CoupInvalideException, CoupDejaJoueException;

    boolean isTerminee();

    String getGagnant() throws PasDeGagnantException;

    String getProprietaire();

    String getInvite();

    String getJoueurCourant();

    Plateau getPlateau();

    void abandonner(String joueur);
}
