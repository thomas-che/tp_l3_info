package modele;

import java.util.Objects;

public class Fichier {
    private String nom;
    private String contenu;
    private String extention;

    public Fichier(String nom, String contenu, String extention){
        this.nom = nom;
        this.contenu = contenu;
        this.extention = extention;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return "Fichier{" +
                "nom='" + nom + '\'' +
                ", contenu='" + contenu + '\'' +
                ", extention='" + extention + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fichier fichier = (Fichier) o;
        return Objects.equals(nom, fichier.nom) &&
                Objects.equals(contenu, fichier.contenu) &&
                Objects.equals(extention, fichier.extention);
    }

}
