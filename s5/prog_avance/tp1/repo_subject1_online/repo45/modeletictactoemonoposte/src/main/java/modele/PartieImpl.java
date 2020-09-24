package modele;

public class PartieImpl implements Partie {

    String proprietaire;
    String invite;

    Plateau plateau;

    String [] joueurs;

    int indiceJoueurCourant;

    public PartieImpl(String proprietaire, String invite) {
        this.proprietaire = proprietaire;
        this.invite = invite;
        this.plateau = Plateau.creerPlateau();
        this.joueurs = new String[] {proprietaire,invite};
        this.indiceJoueurCourant = 0;

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
        return this.plateau.isTerminee();
    }

    @Override
    public String getGagnant() throws PasDeGagnantException {
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
}
