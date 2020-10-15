package modele;

import client.ConnexionBD;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import modele.exceptions.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class FacadeMessagerieImpl implements FacadeMessagerie {
    public static final int TAILLE_PSEUDO_MIN = 0;
    public static final int TAILLE_MDP_MIN = 0;
    private Map<String,Utilisateur> utilisateurs;
    private Collection<Utilisateur> utilisateursConnectes;

    public FacadeMessagerieImpl() {
        this.utilisateurs = new HashMap<>();
        this.utilisateursConnectes = new ArrayList<>();
    }


    private Utilisateur getUtilisateurParNom(String pseudo) throws UtilisateurInexistantException {

        try {
            Statement s = ConnexionBD.getConnecxion().createStatement();
            ResultSet rs =s.executeQuery("SELECT * FROM utilisateurs WHERE nom=\""+pseudo+"\";");
            if (rs.next()) {
                return new Utilisateur(rs.getString("nom"),rs.getString("mdp"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        throw new UtilisateurInexistantException();
    }

    @Override
    public void inscription(String nom, String mdp) throws
            UtilisateurDejaExistantException,
            PseudoIncorrectException {
        try {
            this.getUtilisateurParNom(nom);
            throw new UtilisateurDejaExistantException();
        } catch (UtilisateurInexistantException e) {
            if (Objects.isNull(nom) ||
                    Objects.isNull(mdp) ||
                    nom.length()<= TAILLE_PSEUDO_MIN ||
                    mdp.length()<= TAILLE_MDP_MIN
            ) {
                throw new PseudoIncorrectException();
            }
            else {
//                Utilisateur utilisateur = new Utilisateur(nom,mdp);
//                this.utilisateurs.put(nom,utilisateur);

                // cree la requette pr insert dans la requette
/*                try {
                    Statement st =  ConnexionBD.getConnecxion().createStatement();
                    int nb = st.executeUpdate("INSERT INTO utilisateur VALUES (\""nom"\",\""mdp"\");");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }*/

                // en mode prepare :
                try {
                    /*Statement s = ConnexionBD.getConnecxion().createStatement();
                    ResultSet rs =s.executeQuery("SELECT * FROM utilisateurs WHERE nom=\""+nom+"\";");

                    if (rs.next()){
                        throw new UtilisateurDejaExistantException();
                    }
                    else{
                        PreparedStatement prep_st =  ConnexionBD.getConnecxion().prepareStatement("INSERT INTO utilisateurs VALUES (?,?);");
                        prep_st.setString(1,nom);
                        prep_st.setString(2,mdp);
                        prep_st.executeUpdate();
                    }*/

                    long deb = System.currentTimeMillis();
                    PreparedStatement prep_st =  ConnexionBD.getConnecxion().prepareStatement("INSERT INTO utilisateurs VALUES (?,?);");
                    prep_st.setString(1,nom);
                    prep_st.setString(2,mdp);
                    prep_st.executeUpdate();
                    long fin = System.currentTimeMillis();
                    System.out.println("dif = "+(fin-deb));

                } catch (MySQLIntegrityConstraintViolationException ei) {
                    throw new UtilisateurDejaExistantException();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


            }
        }
    }

    @Override
    public void connexion(String nom, String mdp) throws UtilisateurInexistantException, UtilisateurDejaConnecteException, IdentifiantsIncorrectsException {
        Utilisateur utilisateur = this.getUtilisateurParNom(nom);

        if (utilisateur.checkMdP(mdp)) {
            try {
                PreparedStatement prep_st = ConnexionBD.getConnecxion().prepareStatement("INSERT INTO connecte VALUES (?);");
                prep_st.setString(1,nom);
                prep_st.executeUpdate();
                System.out.println("ajouter dans la table lesConnecter");
            } catch (MySQLIntegrityConstraintViolationException ei) {
                throw new UtilisateurDejaConnecteException();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        else
            throw new IdentifiantsIncorrectsException();
    }

    public String lesConnecte(){
        try {
            Statement st = ConnexionBD.getConnecxion().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM connecte");

            String lesCo = "Liste des user connecter :\n";
            while (rs.next()){
                lesCo+="\t-"+rs.getString(1)+"\n";
            }
            return lesCo;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void deconnexion(String nom) throws
            UtilisateurNonConnecteException,
            UtilisateurInexistantException {
        Utilisateur utilisateur = this.getUtilisateurParNom(nom);

        try {
            Statement s1 = ConnexionBD.getConnecxion().createStatement();
            int nbr = s1.executeUpdate("DELETE FROM connecte WHERE nom=\""+nom+"\";");
            System.out.println("user deco");
            if(nbr==0){ // sa veux dire que il c'est rien passer dans le delete
                throw new UtilisateurNonConnecteException();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void resiliation(String nom, String mdp) throws IdentifiantsIncorrectsException {
        try {
            Utilisateur utilisateur = this.getUtilisateurParNom(nom);
            if (utilisateur.checkMdP(mdp)) {
                this.utilisateurs.remove(utilisateur);
                this.utilisateursConnectes.remove(utilisateur);
            }
            else
                throw new IdentifiantsIncorrectsException();
        } catch (UtilisateurInexistantException e) {
            throw new IdentifiantsIncorrectsException();
        }

    }

    @Override
    public void creationDiscussion(String createur, String destinataire) throws DiscussionDejaExistanteException,
            DestinataireInconnuException,
            UtilisateurInexistantException,
            UtilisateurNonConnecteException {
        Utilisateur cUtilisateur = this.getUtilisateurParNom(createur);
        if (!this.utilisateursConnectes.contains(cUtilisateur))
            throw new UtilisateurNonConnecteException();
        try {
            Utilisateur dUtilisateur = this.getUtilisateurParNom(destinataire);
            try {
                cUtilisateur.getDiscussion(dUtilisateur);
                throw new DiscussionDejaExistanteException();
            } catch (sujet4.modele.exceptions.DiscussionInexistanteException e) {
                e.printStackTrace();
            }
        }
        catch (UtilisateurInexistantException e) {
            throw new DestinataireInconnuException();
        }

    }

    @Override
    public void envoyerMessage(String envoyeur, String destinataire,
                               String message) throws
            UtilisateurNonConnecteException,
            DestinataireInconnuException,
            MessageIncorrectException, UtilisateurInexistantException {
        Utilisateur utilisateur = this.getUtilisateurParNom(envoyeur);
        if (!this.utilisateursConnectes.contains(utilisateur)) {
            throw new UtilisateurNonConnecteException();
        }
        try {
            Utilisateur dest = this.getUtilisateurParNom(destinataire);
            try {
                Discussion discussion = utilisateur.getDiscussion(dest);
                discussion.ajouterMessage(new Message(utilisateur,message));
            } catch (sujet4.modele.exceptions.DiscussionInexistanteException e) {
                e.printStackTrace();
            }
        }
        catch (UtilisateurInexistantException e) {
            throw new DestinataireInconnuException();
        }


    }

    @Override
    public Collection<Discussion> getDiscussion(String demandeur)
            throws UtilisateurNonConnecteException, UtilisateurInexistantException {
        Utilisateur utilisateur = this.getUtilisateurParNom(demandeur);

        // todo : requet connecter
        if (!this.utilisateursConnectes.contains(utilisateur)) {
            throw new UtilisateurNonConnecteException();
        }

        // on charge toute les discution

    Collection<Discussion> lesDiscussion = new ArrayList<>();

        try {
            // discussion ou le damandeur est le user 1
            PreparedStatement prep_st = ConnexionBD.getConnecxion().prepareStatement("SELECT * from discussion where user1 = ? ");
            prep_st.setString(1,demandeur);
            ResultSet rs = prep_st.executeQuery();
            while (rs.next()){
                Utilisateur u2 = getUtilisateurParNom(rs.getString("user2"));
                Discussion d = new Discussion(utilisateur,u2);
                lesDiscussion.add(d);
            }

            // discussion ou le damandeur est le user 2
            prep_st = ConnexionBD.getConnecxion().prepareStatement("SELECT * from discussion where user2 = ? ");
            prep_st.setString(1,demandeur);
            rs = prep_st.executeQuery();
            while (rs.next()){
                Utilisateur u1 = getUtilisateurParNom(rs.getString("user1"));
                Discussion d = new Discussion(u1,utilisateur);
                lesDiscussion.add(d);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return lesDiscussion;
    }

    /**
     *
     * @param d
     * @param id_d
     */
    private void loadMessage(Discussion d, int id_d, Utilisateur u1, Utilisateur u2){
        PreparedStatement prep_st = null;
        try {
            prep_st = ConnexionBD.getConnecxion().prepareStatement("SELECTE * FROM message WHERE id_d=?;");
            prep_st.setInt(1,id_d);
            ResultSet rs = prep_st.executeQuery();
            while (rs.next()){
                /*Utilisateur user = getUtilisateurParNom(rs.getString("user"));*/ // on cree 50 fois le meme user....
                String envoyer_str = rs.getString("envoyer");
                String msg = rs.getString("msg");
                Utilisateur envoyer = envoyer_str.equals(u1.getNom()) ? u1 : u2; // eviter d avoir 50 fois le meme utilisateur
                Message m = new Message(envoyer,rs.getString("msg"));
                d.ajouterMessage(m);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }



}
