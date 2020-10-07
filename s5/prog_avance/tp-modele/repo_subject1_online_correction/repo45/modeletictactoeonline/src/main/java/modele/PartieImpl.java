package modele;

import exceptions.CoupDejaJoueException;
import exceptions.CoupInvalideException;
import exceptions.PasDeGagnantException;
import exceptions.TricheurException;

public class PartieImpl implements Partie {

    String proprietaire;
    String invite;

    Plateau plateau;

    String [] joueurs;
    Boolean abandon;
    String vainqueurParAbandon;



    int indiceJoueurCourant;

    public PartieImpl(String proprietaire, String invite) {
        this.proprietaire = proprietaire;
        this.invite = invite;
        this.plateau = Plateau.creerPlateau();
        this.joueurs = new String[] {proprietaire,invite};
        this.indiceJoueurCourant = 0;
        this.abandon = false;
        this.vainqueurParAbandon = null;

    }

    @Override
    public void jouerCoup(String joueur, int x, int y) throws TricheurException, CoupInvalideException, CoupDejaJoueException {
        if (!joueur.equals(joueurs[indiceJoueurCourant])) {
            throw new TricheurException();
        }

        this.plateau.ajouterCoup(indiceJoueurCourant,x,y);
        this.indiceJoueurCourant = (this.indiceJoueurCourant +1) %2;
    }

    @Override
    public boolean isTerminee() {
        if (this.abandon) {
            return true;
        }
        return this.plateau.isTerminee();
    }

    @Override
    public String getGagnant() throws PasDeGagnantException {
        if (abandon) {
            return vainqueurParAbandon;
        }

        return joueurs[plateau.getGagnant()];
    }

    @Override
    public String getProprietaire() {
        return proprietaire;
    }

    @Override
    public String getInvite() {
        return invite;
    }

    @Override
    public String getJoueurCourant() {
        return this.joueurs[indiceJoueurCourant];
    }

    @Override
    public Plateau getPlateau() {
        return plateau;
    }

    @Override
    public void abandonner(String joueur) {
        vainqueurParAbandon = this.joueurs[0].equals(joueur)?this.joueurs[1]:this.joueurs[0];
        this.abandon = true;

    }
}
