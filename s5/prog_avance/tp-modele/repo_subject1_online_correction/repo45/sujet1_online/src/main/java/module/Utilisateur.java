package module;

public class Utilisateur {
    private String nom;
    private FacadeFileSys fileSys;

    public Utilisateur(String nom) {
        this.nom = nom;
        this.fileSys = new FacadeFileSys();
    }

    public FacadeFileSys getFileSys() {
        return fileSys;
    }

    public String getNom() {
        return nom;
    }
}
