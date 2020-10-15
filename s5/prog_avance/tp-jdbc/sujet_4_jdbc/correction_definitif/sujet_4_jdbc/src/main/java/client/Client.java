package client;

import modele.FacadeMessagerieImpl;
import modele.exceptions.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Client {
    public static void main(String[] args) throws UtilisateurInexistantException, UtilisateurDejaConnecteException, IdentifiantsIncorrectsException, UtilisateurNonConnecteException {
        FacadeMessagerieImpl facade = new FacadeMessagerieImpl();

        facade.connexion("thomas","thomas");
        System.out.println(facade.lesConnecte());
        facade.connexion("zeaze","thomas");



        /*
                pr recuperer la clef=id gener en auto increment
         */
        /*try {
            Statement st = ConnexionBD.getConnecxion().createStatement();
            st.executeUpdate("INSERt INTO test(valeur) VALUES(1);",Statement.RETURN_GENERATED_KEYS); // recuperer l'auto increment
            ResultSet rt = st.getGeneratedKeys(); // return l'auto increment cree
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }*/

    }
}
