package modele;



import java.util.Date;

public interface Message {
    static Message creer(String message, Date time) {
        return new MessageImpl(message,time);
    }

    String getMessage();

    Date getDate();
}
