package facade;

import exceptions.*;
import modele.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FacadeTicTacToeOnlineImpl implements FacadeTicTacToeOnLine {

    public static final int TAILLE_MINIMUM = 3;
    private Map<String, Partie> lesJoueursConnectes;
    private Map<String,Partie> lesInvites;

    public FacadeTicTacToeOnlineImpl() {
        lesInvites = new HashMap<>();
        lesJoueursConnectes = new HashMap<>();
    }



    @Override
    public void creerPartie(String proprietaire, String invite) throws PseudosIncorrectsException, PseudoDejaUtiliseException {
        if (Objects.isNull(proprietaire) || Objects.isNull(invite) ||
                proprietaire.length()<TAILLE_MINIMUM || invite.length()< TAILLE_MINIMUM) {
            throw new PseudosIncorrectsException();
        }

        if (lesJoueursConnectes.containsKey(proprietaire) || lesJoueursConnectes.containsKey(invite) ||
            lesInvites.containsKey(proprietaire) || lesInvites.containsKey(invite)) {
            throw new PseudoDejaUtiliseException();
        }

        Partie partie = Partie.creerPartie(proprietaire,invite);
        lesJoueursConnectes.put(proprietaire,partie);
        lesInvites.put(invite,partie);


    }

    @Override
    public void rejoindre(String invite) throws PartieNonTrouveeException, DejaConnecteException {
        if (Objects.isNull(lesInvites.get(invite))) {
            if (lesJoueursConnectes.containsKey(invite)) {
                throw new DejaConnecteException();
            }
            else {
                throw new PartieNonTrouveeException();
            }
        }
        Partie partie = lesInvites.get(invite);
        lesInvites.remove(invite);
        lesJoueursConnectes.put(invite,partie);

    }


    private void checkPartie(String joueur) throws PartieNonTrouveeException {
        if (Objects.isNull(this.lesJoueursConnectes.get(joueur))) {
            throw new PartieNonTrouveeException();
        }

    }


    @Override
    public void jouerCoup(String joueur, int x, int y) throws TricheurException, CoupInvalideException, CoupDejaJoueException, PartieNonTrouveeException {
        checkPartie(joueur);
        this.lesJoueursConnectes.get(joueur).jouerCoup(joueur,x,y);

    }

    @Override
    public String getJoueurCourant(String joueur) throws PartieNonTrouveeException {
        checkPartie(joueur);
        return this.lesJoueursConnectes.get(joueur).getJoueurCourant();
    }

    @Override
    public Plateau getPlateau(String joueur) throws PartieNonTrouveeException {
        checkPartie(joueur);
        return this.lesJoueursConnectes.get(joueur).getPlateau();
    }

    @Override
    public boolean isPartieTerminee(String joueur) throws PartieNonTrouveeException {
        checkPartie(joueur);
        return this.lesJoueursConnectes.get(joueur).isTerminee();
    }

    @Override
    public String getGagnant(String joueur) throws PasDeGagnantException, PartieNonTrouveeException {
        checkPartie(joueur);
        return this.lesJoueursConnectes.get(joueur).getGagnant();
    }


    @Override
    public void quitter(String joueur) throws PartieNonTrouveeException {
        checkPartie(joueur);
        if (!lesJoueursConnectes.get(joueur).isTerminee()) {
           this.lesJoueursConnectes.get(joueur).abandonner(joueur);
        }
        this.lesJoueursConnectes.remove(joueur);

    }

    @Override
    public Collection<String> getJoueursConnectes() {
        return this.lesJoueursConnectes.keySet();
    }
}
