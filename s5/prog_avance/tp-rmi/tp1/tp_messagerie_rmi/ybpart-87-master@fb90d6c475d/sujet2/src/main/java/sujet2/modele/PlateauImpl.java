package sujet2.modele;


import sujet2.modele.exceptions.CaseDejaOccupeeException;
import sujet2.modele.exceptions.CoupIncorrectException;
import sujet2.modele.exceptions.EgaliteException;
import sujet2.modele.exceptions.PartieNonTermineeException;

import java.util.Objects;

/**
 * L'idée sera d'associer au joueur 1 la valeur 2 et au joueur 2 la valeur
 * 7. trois cases alignées avec comme somme totale 6 -> joueur 1 gagnant
 * et 21 -> joueur 2 gagnant. Le reste non gagnant
 */




public class PlateauImpl implements Plateau {
    private String joueur1;
    private String joueur2;
    private String joueurCourant;

    private int nbCoups=0;
    private static final int VALEUR_JOUEUR1 =2;
    private static final int VALEUR_JOUEUR2 = 7;
    private static final int TAILLE = 3;
    private int[][] plateau;
    private String gagnant;


    public PlateauImpl(String joueur1, String joueur2) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.joueurCourant = joueur1;
        this.plateau = new int[TAILLE][TAILLE];
    }


    private int getValeurJoueurCourant() {
        if (this.getJoueurCourant().equals(joueur1)) {
            return VALEUR_JOUEUR1;
        } else {
            return VALEUR_JOUEUR2;
        }
    }

    @Override
    public void jouer(int x, int y) throws CoupIncorrectException, CaseDejaOccupeeException, PartieTermineeException {

        if (!this.partieTerminee()) {
            if (x < 0 || x >= TAILLE || y < 0 || y >= TAILLE) {
                throw new CoupIncorrectException();
            }

            if (this.plateau[x][y] != 0) {
                throw new CaseDejaOccupeeException();
            }

            this.plateau[x][y] = this.getValeurJoueurCourant();
            this.joueurCourant = joueurCourant.equals(joueur1) ? joueur2 : joueur1;
            this.nbCoups++;
        }
        else
            throw new PartieTermineeException();
//        this.partieTerminee();
    }


    private String getGagnantSelonScore(int score) {
        if (score == TAILLE * VALEUR_JOUEUR1) {
            return joueur1;
        } else {
            if (score == TAILLE * VALEUR_JOUEUR2) {
                return joueur2;
            } else
                return null;
        }
    }
    @Override
    public boolean partieTerminee() {
        int diagonale1=0;
        int diagonale2 = 0;

        for(int i=0;i<TAILLE;i++) {
            int somme =0;
            for (Integer x : plateau[i]) {
                somme +=x;
            }

            if (somme == TAILLE*VALEUR_JOUEUR1 || somme == TAILLE*VALEUR_JOUEUR2) {
                this.gagnant = this.getGagnantSelonScore(somme);
                return true;
            }

            somme = plateau[0][i]+plateau[1][i] + plateau[2][i];
            if (somme == TAILLE*VALEUR_JOUEUR1 || somme == TAILLE*VALEUR_JOUEUR2) {
                this.gagnant = this.getGagnantSelonScore(somme);
                return true;
            }

            diagonale1 += plateau[i][i];
            diagonale2 += plateau[(TAILLE-1)-i][i];
        }


        if (diagonale1 == TAILLE*VALEUR_JOUEUR1 || diagonale1 == TAILLE*VALEUR_JOUEUR2) {
            this.gagnant = this.getGagnantSelonScore(diagonale1);
            return true;
        }

        if (diagonale2 == TAILLE*VALEUR_JOUEUR1 || diagonale2 == TAILLE*VALEUR_JOUEUR2) {
            this.gagnant = this.getGagnantSelonScore(diagonale2);
            return true;
        }

        if (this.nbCoups == TAILLE*TAILLE) {
            return true;
        }
        return false;
    }

    @Override
    public void rejouerPartie() {
        this.plateau = new int[TAILLE][TAILLE];
        this.joueurCourant = joueur1;
        this.nbCoups = 0;

    }

    @Override
    public void quitter() {
        this.gagnant = this.joueurCourant.equals(joueur1)?joueur2:joueur1;
    }

    @Override
    public String getGagnant() throws PartieNonTermineeException, EgaliteException {
        if (this.partieTerminee()) {
            if (!Objects.isNull(gagnant)) {
                return gagnant;
            }
            else {
                throw new EgaliteException();
            }
        }
        else
            throw new PartieNonTermineeException();
    }

    @Override
    public String getJoueurCourant() {
        return this.joueurCourant;
    }
}
