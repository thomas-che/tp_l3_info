package modele;


import java.util.Date;

public class MessageImpl implements Message {

    String message;
    Date date;


    MessageImpl(String message, Date time) {
        this.message = message;
        this.date = time;
    }

    @Override
    public String getMessage() {
        return message;
    }


    @Override
    public Date getDate() {
        return date;
    }

}
