package modele;

import java.util.Objects;

public class PersonneImpl implements Personne {

    String identifiant;
    String mdp;



    PersonneImpl(String identifiant, String mdp) {
        this.identifiant = identifiant;
        this.mdp = mdp;
        Objects.requireNonNull(mdp);
        Objects.requireNonNull(identifiant);
    }

    @Override
    public String getIdentifiant() {
        return identifiant;
    }

    @Override
    public boolean checkPassword(String mdp) {
        return this.mdp.equals(mdp);
    }
}
