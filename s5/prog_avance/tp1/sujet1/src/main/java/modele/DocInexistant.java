package modele;

public class DocInexistant extends Exception {
    private String nomDoc;
    public DocInexistant(String nomDoc) {
        super();
        this.nomDoc=nomDoc;
    }

    public String getNomPb() {
        return nomDoc;
    }

    public String getMessage(){
        return "dossier innexistant : "+this.nomDoc;
    }
}
