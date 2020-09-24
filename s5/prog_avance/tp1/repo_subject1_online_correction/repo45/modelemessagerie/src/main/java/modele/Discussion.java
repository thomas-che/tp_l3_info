package modele;

import java.util.List;

public interface Discussion {
    static Discussion creer(Personne identifiant, Personne destinataire) {
        return new DiscussionImpl(identifiant,destinataire);
    }

    long getId();

    void addMessage(String message);

    List<Message> getMessages();
}
