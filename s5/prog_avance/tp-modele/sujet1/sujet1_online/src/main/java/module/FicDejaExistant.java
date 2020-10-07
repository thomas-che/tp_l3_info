package module;

public class FicDejaExistant extends Exception {
    private String nomFic;
    public FicDejaExistant(String nomFic) {
        super();
        this.nomFic=nomFic;
    }

    public String getNomPb() {
        return nomFic;
    }

    public String getMessage(){
        return "fichier deja existant : "+this.nomFic;
    }
}
