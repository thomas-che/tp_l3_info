package modele;

import java.util.HashMap;
import java.util.Map;

public class Discussion {
    private String titre;
    private String from;
    private String to;
    private String date;
    private Map<Integer, Message> laDiscussion;


    public static int compteur = 0;
    private static int num ;


    public Discussion(String titre, String from, String to, String date, String msg) {
        this.titre = titre;
        this.from = from;
        this.to = to;
        this.date = date;
        Message message = new Message(from, to, date, msg);
        this.num = compteur++;
        this.laDiscussion = new HashMap<>() ;
        laDiscussion.put(num,message);
    }

    public void envoiMsg(String nom, String to_, String msg_) {
        String date_ = "10-01-2020";
        Message message = new Message(nom, to_, date_, msg_);
        this.num = compteur++;
        laDiscussion.put(num,message);
    }

    @Override
    public String toString() {
        return "Discussion{\n" +
                "titre='" + titre + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", date='" + date + '\'' +
                ", \n\tlaDiscussion=" +laDiscussion +
                "\n\t}\n";
    }
}
