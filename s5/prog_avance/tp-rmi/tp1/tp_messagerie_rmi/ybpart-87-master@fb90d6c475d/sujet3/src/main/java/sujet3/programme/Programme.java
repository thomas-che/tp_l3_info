package sujet3.programme;

import sujet3.facade.*;
import sujet3.modele.PartieInexistanteException;
import sujet2.modele.PartieTermineeException;
import sujet3.modele.PasVotreTourException;
import sujet3.modele.PseudoDejaDansUnePartieException;
import sujet2.modele.exceptions.*;

public class Programme {

    public static void main(String[] args) throws PseudoDejaDansUnePartieException, PseudoIncorrectException, PartieInexistanteException, PasVotreTourException, CoupIncorrectException, PartieTermineeException, CaseDejaOccupeeException, PartieNonTermineeException, EgaliteException {
        FacadeTicTacToeOnLine facadeTicTacToeOnLine =
                new FacadeTicTacToeOnlineImpl();
        String joueur1 = "yohan";
        String joueur2 = "fred";
        String token = facadeTicTacToeOnLine.creerPartie(joueur1);
        facadeTicTacToeOnLine.rejoindrePartie(joueur2,token);
        facadeTicTacToeOnLine.jouer(joueur1,1,1);
        facadeTicTacToeOnLine.jouer(joueur2,2,1);

        facadeTicTacToeOnLine.jouer(joueur1,2,0);
        facadeTicTacToeOnLine.jouer(joueur2,0,2);

        facadeTicTacToeOnLine.jouer(joueur1,0,0);
        facadeTicTacToeOnLine.jouer(joueur2,2,2);

        facadeTicTacToeOnLine.jouer(joueur1,1,0);
        //facadeTicTacToeOnLine.jouer(joueur2,2,1);
        System.out.println(facadeTicTacToeOnLine.getGagnant(joueur2));



        joueur1 = "yohan1";
        joueur2 = "fred1";
        token = facadeTicTacToeOnLine.creerPartie(joueur1);
        facadeTicTacToeOnLine.rejoindrePartie(joueur2,token);
        facadeTicTacToeOnLine.jouer(joueur1,1,1);
        facadeTicTacToeOnLine.jouer(joueur2,2,0);

        facadeTicTacToeOnLine.jouer(joueur1,2,1);
        facadeTicTacToeOnLine.jouer(joueur2,0,1);

        facadeTicTacToeOnLine.jouer(joueur1,0,0);
        facadeTicTacToeOnLine.jouer(joueur2,2,2);

        facadeTicTacToeOnLine.jouer(joueur1,1,2);
        facadeTicTacToeOnLine.jouer(joueur2,1,0);
        facadeTicTacToeOnLine.jouer(joueur1,0,2);
        System.out.println(facadeTicTacToeOnLine.getGagnant(joueur2));





    }
}
