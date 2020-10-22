import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name="Essai")
public class Essai implements Serializable {
    private int id;
    private transient String text; // quand champs pas utile, transient
    private String autre;

    // on force serialVersionUID avec l'ancienne version
    //public static final long serialVersionUID=5792049873798025032L;
    public static final long serialVersionUID=1L;

    public String getAutre() {
        return autre;
    }

    public void setAutre(String autre) {
        this.autre = autre;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }+

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Essai{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", autre='" + autre + '\'' +
                '}';
    }
}
