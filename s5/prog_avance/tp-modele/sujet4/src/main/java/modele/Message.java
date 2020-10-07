package modele;

public class Message {
    private String from;
    private String to;
    private String date;
    private String msg;

    public Message(String from, String to, String date, String msg) {
        this.from = from;
        this.to = to;
        this.date = date;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "\n\t\tMessage{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", date='" + date + '\'' +
                ", msg='" + msg + '\'' +
                "}";
    }
}
