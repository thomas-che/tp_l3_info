package modele;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DiscussionImpl implements Discussion {

    List<Message> messages;
    Personne createur;
    Personne invite;
    long id;

    private static long ID_GENERATOR=0;

    public static void reinitID_GENERATOR() {
        ID_GENERATOR =0;
    }

    DiscussionImpl(Personne createur, Personne invite) {
        this.createur = createur;
        this.invite = invite;
        this.messages = new ArrayList<>();
        this.id = ID_GENERATOR++;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void addMessage(String message) {
        Message message1 = Message.creer(message, Calendar.getInstance().getTime());
        this.messages.add(message1);
    }

    @Override
    public List<Message> getMessages() {
        return messages;
    }
}
