package sujet3.modele;

import sujet2.modele.exceptions.PseudoIncorrectException;
import sujet2.modele.facade.FacadeTicTacToeOffLine;
import sujet2.modele.facade.FacadeTicTacToeOffLineImpl;

public class PartieImpl implements Partie {
    private String identifiant;
    private String createur;
    private String invite;
    FacadeTicTacToeOffLine partie;

    @Override
    public String getIdentifiant() {
        return identifiant;
    }

    @Override
    public String getCreateur() {
        return createur;
    }

    @Override
    public String getInvite() {
        return invite;
    }

    @Override
    public FacadeTicTacToeOffLine getPartie() {
        return partie;
    }

    public PartieImpl(String joueur1, String identifiant) {
        this.identifiant = identifiant;
        this.createur = joueur1;
    }

    @Override
    public void rejoindre(String invite) throws PseudoIncorrectException {
        this.invite = invite;
        partie = new FacadeTicTacToeOffLineImpl();
        partie.creerPartie(this.createur,this.invite);
    }


}
