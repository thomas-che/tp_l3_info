package sujet3.modele;

import sujet2.modele.exceptions.PseudoIncorrectException;
import sujet2.modele.facade.FacadeTicTacToeOffLine;

public interface Partie {
    String getIdentifiant();

    String getCreateur();

    String getInvite();

    FacadeTicTacToeOffLine getPartie();

    void rejoindre(String invite) throws PseudoIncorrectException;
}
