package facade;

import modele.exceptions.PseudoIncorrectException;
import modele.facade.FacadeTicTacToeOffLine;

public interface Partie {
    String getIdentifiant();

    String getCreateur();

    String getInvite();

    FacadeTicTacToeOffLine getPartie();

    void rejoindre(String invite) throws PseudoIncorrectException;
}
