package modele;

public class Fichier implements Composant{
    private String nom;
    private String extension;
    private String contenu;

    public Fichier(String nom, String extension, String contenu) {
        this.nom = nom;
        this.extension = extension;
        this.contenu = contenu;
    }


    @Override
    public String getNom() {
        return this.nom;
    }

    public String getExtension() {
        return extension;
    }

    public String getContenu() {
        return contenu;
    }
}
