package modele;

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
}
