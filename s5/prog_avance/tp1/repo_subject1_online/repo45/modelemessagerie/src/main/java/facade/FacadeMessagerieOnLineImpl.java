package facade;

import exceptions.*;
import modele.Discussion;
import modele.Personne;

import java.util.*;

public class FacadeMessagerieOnLineImpl implements FacadeMessagerieOnLine {

    private Map<String, Personne> personnesInscrites;

    private Set<Personne> personnesConnectees;


    private Map<Personne, Collection<Discussion>> discussions;


    FacadeMessagerieOnLineImpl() {
        this.personnesConnectees = new HashSet<>();
        this.personnesInscrites = new HashMap<>();
        this.discussions = new HashMap<>();
    }

    @Override
    public void inscription(String identifiant, String mdp) throws PseudoDejaPrisException, MauvaisFormatDonneesException {
        Personne personne = this.personnesInscrites.get(identifiant);
        if (Objects.nonNull(personne)) {
            throw new PseudoDejaPrisException();
        }

        if (Objects.isNull(identifiant) || Objects.isNull(mdp) ||
        identifiant.length()<3 || mdp.length() < 3) {
            throw new MauvaisFormatDonneesException();
        }

        personne = Personne.creer(identifiant,mdp);
        this.personnesInscrites.put(identifiant,personne);
        this.discussions.put(personne,new ArrayList<>());
    }




    @Override
    public void desincription(String identifiant, String mdp) throws OperationNonAuthoriseeException {
        Personne personne = this.personnesInscrites.get(identifiant);
        if (Objects.isNull(personne) || !personne.checkPassword(mdp)) {
            throw new OperationNonAuthoriseeException();
        }

        this.personnesInscrites.remove(identifiant);
        this.personnesConnectees.remove(personne);
        this.discussions.remove(personne);
    }

    @Override
    public void connexion(String identifiant, String mdp) throws PersonneDejaConnecteeException, IdentificationException, OperationNonAuthoriseeException {

        Personne personne = this.personnesInscrites.get(identifiant);

        if (Objects.isNull(identifiant)) {
            throw new IdentificationException();
        }

        if (personnesConnectees.contains(personne))
            throw new PersonneDejaConnecteeException();

        if (!personne.checkPassword(mdp)) {
            throw new OperationNonAuthoriseeException();
        }

        this.personnesConnectees.add(personne);


    }

    @Override
    public void deconnexion(String identifiant) {

        Personne p = this.personnesInscrites.get(identifiant);
        this.personnesConnectees.remove(p);

    }

    @Override
    public Discussion getDiscussionById(String identifiant, long id) throws DiscussionNonTrouveeException, OperationNonAuthoriseeException {
        Personne personne = this.personnesInscrites.get(identifiant);
        if (!personnesConnectees.contains(personne))
            throw new OperationNonAuthoriseeException();

        for (Discussion d: this.discussions.get(personne)) {
            if (d.getId() == id)
                return d;
        }

        throw new DiscussionNonTrouveeException();
    }

    @Override
    public Collection<Discussion> getAllDiscussions(String identifiant) throws OperationNonAuthoriseeException {
        Personne personne = this.personnesInscrites.get(identifiant);
        if (!personnesConnectees.contains(personne))
            throw new OperationNonAuthoriseeException();
        return this.discussions.get(personne);
    }

    @Override
    public void envoyerMessage(String identifiant, long idDiscussion, String message) throws OperationNonAuthoriseeException, DiscussionNonTrouveeException {
        Personne personne = this.personnesInscrites.get(identifiant);
        if (!personnesConnectees.contains(personne))
            throw new OperationNonAuthoriseeException();

        Discussion discussion = this.getDiscussionById(identifiant, idDiscussion);
        discussion.addMessage(message);
    }

    @Override
    public void creerDiscussion(String identifiant, String destinataire) throws OperationNonAuthoriseeException, DestinataireInexistantException {
        Personne personne = this.personnesInscrites.get(identifiant);
        if (!personnesConnectees.contains(personne))
            throw new OperationNonAuthoriseeException();

        if (Objects.isNull(personnesInscrites.get(destinataire))) {
            throw new DestinataireInexistantException();
        }

        Discussion discussion = Discussion.creer(personne,this.personnesInscrites.get(destinataire));
        getAllDiscussions(identifiant).add(discussion);
    }


    @Override
    public Collection<String> getAllPseudosInscrits(String identifiant) throws OperationNonAuthoriseeException {
        Personne personne = this.personnesInscrites.get(identifiant);
        if (!personnesConnectees.contains(personne))
            throw new OperationNonAuthoriseeException();

        return this.personnesInscrites.keySet();
    }
}
