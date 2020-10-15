package sujet2.modele.facade;

import sujet2.modele.PartieTermineeException;
import sujet2.modele.Plateau;
import sujet2.modele.PlateauImpl;
import sujet2.modele.exceptions.*;

import java.util.Objects;

public class FacadeTicTacToeOffLineImpl implements
FacadeTicTacToeOffLine {

    private Plateau plateauJeu;



    @Override
    public void creerPartie(String joueur1, String joueur2) throws PseudoIncorrectException {
        if(Objects.isNull(joueur1) || Objects.isNull(joueur2) ||
        joueur1.length()<=0 || joueur2.length()<=0 ||
        joueur1.equals(joueur2)) {
            throw new PseudoIncorrectException();
        }

        plateauJeu = new PlateauImpl(joueur1,joueur2);

    }

    @Override
    public void jouer(int x, int y) throws CoupIncorrectException, CaseDejaOccupeeException, PartieTermineeException {
        plateauJeu.jouer(x,y);
    }

    @Override
    public boolean partieTerminee() {
        return this.plateauJeu.partieTerminee();
    }

    @Override
    public void rejouerPartie() {
        this.plateauJeu.rejouerPartie();

    }

    @Override
    public void quitter() {
        this.plateauJeu.quitter();
    }

    @Override
    public Plateau getPlateau() {
        return this.plateauJeu;
    }

    @Override
    public String getGagnant() throws PartieNonTermineeException, EgaliteException {
        return this.plateauJeu.getGagnant();
    }

    @Override
    public String getJoueurCourant() {
        return this.plateauJeu.getJoueurCourant();
    }
}
