package modele;

public interface Personne {
    static Personne creer(String identifiant, String mdp) {

        return new PersonneImpl(identifiant,mdp);
    }

    String getIdentifiant();

    boolean checkPassword(String mdp);
}
