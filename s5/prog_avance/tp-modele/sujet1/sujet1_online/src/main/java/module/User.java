package module;

public class User {
    private String nom;
    private String prenom;
    private String password;
    private static int id;

    public static int compteur = 1;

    public User(String nom, String prenom, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;
        this.id = compteur++;
    }






}
