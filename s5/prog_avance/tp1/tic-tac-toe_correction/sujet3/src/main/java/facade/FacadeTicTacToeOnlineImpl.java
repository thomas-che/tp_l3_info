package facade;

import modele.PartieTermineeException;
import modele.Plateau;
import modele.exceptions.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class FacadeTicTacToeOnlineImpl implements FacadeTicTacToeOnLine {

    private Collection<Partie> partiesEncours;
    private Collection<Partie> partiesEnAttente;

    public FacadeTicTacToeOnlineImpl() {
        this.partiesEncours = new ArrayList<>();
        this.partiesEnAttente = new ArrayList<>(); /*partie cree mais pas encore rejoint*/
    }

    @Override
    public String creerPartie(String joueur1) throws PseudoIncorrectException, PseudoDejaDansUnePartieException {
        if (Objects.isNull(joueur1) || joueur1.length()<=0)
            throw new PseudoIncorrectException();

        try {
            this.getPartieDuJoueurEnAttente(joueur1);
        }
        catch (PartieInexistanteException e) {
            try {
                this.getPartieDuJoueur(joueur1);
            } catch (PartieInexistanteException partieInexistanteException) {
                String identifiant = "partie-"+joueur1;
                Partie partie = new PartieImpl(joueur1,identifiant);
                this.partiesEnAttente.add(partie);
                return identifiant; /*retounr l identifiant de la partie pr laure rejoint*/
            }
        }
        throw new PseudoDejaDansUnePartieException();



    }


    private Partie getPartieByIdentifiant(Collection<Partie> parties, String identifiant) throws PartieInexistanteException {
        for (Partie partie : parties) {
            if (partie.getIdentifiant().equals(identifiant)) {
                return partie;
            }
        }
        throw new PartieInexistanteException();
    }

    @Override
    public void rejoindrePartie(String joueur2, String jeton) throws
            PartieInexistanteException,
            PseudoIncorrectException, PseudoDejaDansUnePartieException {
        try {
            this.getPartieDuJoueur(joueur2); /*cherche partie pr le joueur 2*/
            throw new PseudoDejaDansUnePartieException();
        }
        catch (PartieInexistanteException e) {
            try {
                this.getPartieDuJoueurEnAttente(joueur2); /*j2 dans une partie en attente*/
                throw new PseudoDejaDansUnePartieException();
            }
            catch (PartieInexistanteException e1) {
                Partie partie = this.getPartieByIdentifiant(this.partiesEnAttente,jeton);
                partie.rejoindre(joueur2);
                this.partiesEnAttente.remove(partie); /* rejoin la partie ducoup suprime de la liste des partie en attente*/
                this.partiesEncours.add(partie);

            }

        }


    }


    private Partie getPartieDuJoueur(String nomJoueur) throws PartieInexistanteException {

        for (Partie partie : this.partiesEncours) {
            if (partie.getCreateur().equals(nomJoueur) ||
            partie.getInvite().equals(nomJoueur))
                return partie;
        }
        throw new PartieInexistanteException();
    }

    private Partie getPartieDuJoueurEnAttente(String nomJoueur) throws PartieInexistanteException {

        for (Partie partie : this.partiesEnAttente) {
            if (partie.getCreateur().equals(nomJoueur))
                return partie;
        }
        throw new PartieInexistanteException();
    }

    @Override
    public void jouer(String nomJoueur, int x, int y) throws
            CoupIncorrectException, CaseDejaOccupeeException, PartieInexistanteException, PasVotreTourException, PartieTermineeException {
        Partie partie = this.getPartieDuJoueur(nomJoueur);
        if (partie.getPartie().getJoueurCourant().equals(nomJoueur)) {
            partie.getPartie().jouer(x,y);
        }
        else
            throw new PasVotreTourException();
    }

    @Override
    public boolean partieTerminee(String nomJoueur) throws PartieInexistanteException {
        Partie partie = this.getPartieDuJoueur(nomJoueur);
        return partie.getPartie().partieTerminee();
    }

    @Override
    public void quitter(String nomJoueur) throws PartieInexistanteException {
        Partie partie = this.getPartieDuJoueur(nomJoueur);
        partie.getPartie().quitter();
    }

    @Override
    public Plateau getPlateau(String nomJoueur) throws PartieInexistanteException {
        Partie partie = this.getPartieDuJoueur(nomJoueur);
        return partie.getPartie().getPlateau();
    }

    @Override
    public String getGagnant(String nomJoueur) throws PartieNonTermineeException, EgaliteException, PartieInexistanteException {
        Partie partie = this.getPartieDuJoueur(nomJoueur);
        return partie.getPartie().getGagnant();
    }

    @Override
    public String getJoueurCourant(String nomJoueur) throws PartieInexistanteException {
        Partie partie = this.getPartieDuJoueur(nomJoueur);
        return partie.getPartie().getJoueurCourant();
    }
}
