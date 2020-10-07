package modele;

public interface FacadeTicTacToeLocal {


    void creerPartie(String proprietaire, String invite) throws PseudosIncorrectsException;

    void jouerCoup(String joueur, int x, int y) throws TricheurException, CoupInvalideException, CoupDejaJoueException;

    String getJoueurCourant();

    Plateau getPlateau();

    boolean isPartieTerminee();

    String getGagnant() throws PasDeGagnantException;

    void rejouer();


    void quitter();
}
