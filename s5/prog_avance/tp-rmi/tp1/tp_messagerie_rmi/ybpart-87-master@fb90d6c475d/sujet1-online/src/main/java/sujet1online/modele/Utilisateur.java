package sujet1online.modele;

import sujet1.facade.FacadeFileSystem;

public class Utilisateur {
    private String nom;
    FacadeFileSystem fileSystem;

    public Utilisateur(String nom) {
        this.nom = nom;
        fileSystem = new FacadeFileSystem("/");
    }

    public String getNom() {
        return nom;
    }

    public FacadeFileSystem getFileSystem() {
        return fileSystem;
    }
}
