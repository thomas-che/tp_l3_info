package modele;

public class Joueur {
    private String nom;
    private int pion ;

    public Joueur(String nom, int pion) {
        this.nom = nom;
        this.pion = pion;
    }

    public String getNom() {
        return nom;
    }

    public int getPion() {
        return pion;
    }
}
