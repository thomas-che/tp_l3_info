package modele;

public interface Plateau {
    static Plateau creerPlateau() {
        return new PlateauImpl();
    }

    Integer[][] getPlateau();

    void ajouterCoup(int indiceJoueurCourant, int x, int y) throws CoupInvalideException, CoupDejaJoueException;

    boolean isTerminee();

    int getGagnant() throws PasDeGagnantException;
}
