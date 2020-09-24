package modele;

public class PlateauImpl implements Plateau {

    public static final int TAILLE = 3;
    public static final int NB_COUPS_MAX = 9;
    private Integer plateau[][];

    private Coup last;
    private int nbCoups;

    public PlateauImpl() {
        plateau = new Integer[TAILLE][TAILLE];
        nbCoups = 0;
    }


    private void checkCoup(int x, int y) throws CoupInvalideException {
        if (x<0 || x >=TAILLE || y<0 || y >=TAILLE)
            throw new CoupInvalideException();

    }

    @Override
    public Integer[][] getPlateau() {
        return plateau;
    }

    @Override
    public void ajouterCoup(int indiceJoueurCourant, int x, int y) throws CoupInvalideException, CoupDejaJoueException {

        this.checkCoup(x,y);
        if (plateau[x][y] != null) {
            throw new CoupDejaJoueException();
        }

        plateau[x][y] = indiceJoueurCourant;
        last = Coup.nouveauCoup(x,y);
        nbCoups++;
    }

    @Override
    public boolean isTerminee() {
        if (nbCoups >= NB_COUPS_MAX) {
            return true;
        }
        try {
            this.getGagnant();
            return true;

        } catch (PasDeGagnantException e) {
            return false;
        }
    }

    @Override
    public int getGagnant() throws PasDeGagnantException {


        for (int i=0;i<TAILLE;i++) {
            if (plateau[i][0] == plateau[i][1] && plateau[i][2] == plateau[i][1] &&
                    plateau[i][0] != null)
                return plateau[i][0];
        }

        for (int i=0;i<TAILLE;i++) {
            if (plateau[0][i] == plateau[1][i] && plateau[2][i] == plateau[1][i] &&
                    plateau[0][i] != null)
                return plateau[0][i];
        }

        if (plateau[0][0] == plateau[1][1] && plateau[1][1] == plateau[2][2] && plateau[0][0] != null)
            return plateau[0][0];

        if (plateau[2][0] == plateau[1][1] && plateau[1][1] == plateau[0][2] && plateau[1][1] != null)
            return plateau[0][0];

        throw new PasDeGagnantException();
    }
}
