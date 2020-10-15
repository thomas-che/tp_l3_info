package sujet4.modele;

import java.util.Calendar;
import java.util.Date;

public class Message {
    private Utilisateur envoyeur;
    private String message;
    private Date date;

    public Message(Utilisateur utilisateur, String message) {
        this.envoyeur = utilisateur;
        this.message = message;
        this.date = Calendar.getInstance().getTime();
    }

    public Utilisateur getEnvoyeur() {
        return envoyeur;
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }
}
