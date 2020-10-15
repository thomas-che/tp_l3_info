package modele;

import java.util.ArrayList;
import java.util.List;

public class Discussion {
    private Utilisateur utilisateur1;
    private Utilisateur utilisateur2;
    private List<Message> messages;

    public Discussion(Utilisateur cUtilisateur, Utilisateur dUtilisateur) {
        this.utilisateur1 = cUtilisateur;
        this.utilisateur2 = dUtilisateur;
        this.messages = new ArrayList<>();
    }

    public Utilisateur getUtilisateur1() {
        return utilisateur1;
    }

    public Utilisateur getUtilisateur2() {
        return utilisateur2;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void ajouterMessage(Message message) {
        this.messages.add(message);
    }
}
