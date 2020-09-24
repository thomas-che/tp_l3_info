package modele;

public class DocDejaExistant extends Exception {
    private String nomDocPb;
    public DocDejaExistant(String docNom) {
        super();
        this.nomDocPb=docNom;
    }

    public String getNomPb() {
        return nomDocPb;
    }

    public String getMessage(){
        return "doc deja existant : "+this.nomDocPb;
    }
}
