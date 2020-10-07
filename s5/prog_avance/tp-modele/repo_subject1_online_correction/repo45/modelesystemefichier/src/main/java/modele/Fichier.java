package modele;

public class Fichier implements Item {
    String nom;
    String contenu;

    public Fichier(String nom, String contenu) {
        this.nom = nom;
        this.contenu = contenu;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public void setNom(String nomFutur) {
        this.nom = nomFutur;
    }


    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    @Override
    public String getInfo() {
        return "Fichier "+getNom()+" dont la taille du contenu est "+ contenu.length() + " caracteres";
    }
}
