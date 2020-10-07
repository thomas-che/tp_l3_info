package modele;

import java.util.Objects;

public class FacadeTicTactToeImpl implements FacadeTicTacToeLocal {
    private Partie partieEnCours;




    @Override
    public void creerPartie(String proprietaire, String invite) throws PseudosIncorrectsException {

        if (Objects.isNull(proprietaire) || Objects.isNull(invite) || proprietaire.equals(invite))
            throw new PseudosIncorrectsException();

        this.partieEnCours = Partie.creerPartie(proprietaire,invite);
    }

    @Override
    public void jouerCoup(String joueur, int x, int y) throws TricheurException, CoupInvalideException, CoupDejaJoueException {
        this.partieEnCours.jouerCoup(joueur, x,y);

    }



    @Override
    public String getJoueurCourant() {
        return this.partieEnCours.getJoueurCourant();
    }

    @Override
    public Plateau getPlateau() {
        return this.partieEnCours.getPlateau();
    }


    @Override
    public boolean isPartieTerminee() {

        return partieEnCours.isTerminee();
    }

    @Override
    public String getGagnant() throws PasDeGagnantException {
        return partieEnCours.getGagnant();
    }

    @Override
    public void rejouer() {
        this.partieEnCours = Partie.creerPartie(this.partieEnCours.getProprietaire(),this.partieEnCours.getInvite());
    }

    @Override
    public void quitter() {
        this.partieEnCours = null;
    }
}
