package modele;

public class CorrFichier implements Composant{
    private String nom;
    private String contenu;
    private String extention;

    public CorrFichier(String nom, String contenu, String extention) {
        this.nom = nom;
        this.contenu = contenu;
        this.extention = extention;
    }

    public String getNom() {
        return nom;
    }

    public String getContenu() {
        return contenu;
    }

    public String getExtention() {
        return extention;
    }
}
