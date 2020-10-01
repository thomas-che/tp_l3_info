package facade;

import execption.*;
import modele.Discussion;
import modele.Utilisateur;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Facade {

    private Map<String, Utilisateur> lesUtilisateurs;
    private Map<String, Utilisateur> lesConnecter;

    public Facade() {
        this.lesUtilisateurs = new HashMap<>() ;
        this.lesConnecter = new HashMap<>() ;
    }

    public void inscription (String nom, String pwd) throws ExceptionUtilisateurDejaExistant {
        Utilisateur nouveau_utilisateur = new Utilisateur(nom, pwd);
        if (lesUtilisateurs.containsKey(nom)){
            throw new ExceptionUtilisateurDejaExistant() ;
        }

        lesUtilisateurs.put(nom,nouveau_utilisateur);
        lesConnecter.put(nom,nouveau_utilisateur);
    }

    public void connection (String nom, String pwd) throws ExceptionUtilisateurInexistant, ExceptionUtilisateurDejaConnecter, ExceptionPwdIncorect {
        if (lesConnecter.containsKey(nom)){
            throw new ExceptionUtilisateurDejaConnecter();
        }
        else{
            if (lesUtilisateurs.containsKey(nom)){
                Utilisateur utilisateur = lesUtilisateurs.get(nom);
                if (utilisateur.getPwd().equals(pwd)){
                    lesConnecter.put(nom,utilisateur);
                    System.out.println("user : "+nom+" se connect");
                }
                else {
                    throw new ExceptionPwdIncorect();
                }

            }else{
                throw new ExceptionUtilisateurInexistant();
            }
        }
    }

    public void deconnection (String nom) throws ExceptionUtilisateurPasConnecter {
        if (lesConnecter.containsKey(nom)){
            lesConnecter.remove(nom);
            System.out.println("user : "+nom+" se DEconnect");
        }
        else{
            throw new ExceptionUtilisateurPasConnecter();
        }
    }

    public void creeDiscution (String from, String to, String titre, String msg) throws ExceptionUtilisateurPasConnecter, ExceptionUtilisateurInexistant, ExceptionDejaDiscussionEntreCesDeuxIndividu {
        if (lesConnecter.containsKey(from)){
            if (lesUtilisateurs.containsKey(to)){
                Utilisateur utilisateur_from = lesUtilisateurs.get(from);
                utilisateur_from.creeDiscussion(titre,to,msg);
                System.out.println("Discussion est cree : FROM");
                Utilisateur utilisateur_to = lesUtilisateurs.get(to);
                utilisateur_to.creeDiscussion(titre,from,msg);
                System.out.println("Discussion est cree : TO");
            }else {
                throw new ExceptionUtilisateurInexistant();
            }
        }
        else{
            throw new ExceptionUtilisateurPasConnecter();
        }
    }

    public void envoiMsg (String from, String to, String msg) throws ExceptionUtilisateurInexistant, ExceptionUtilisateurPasConnecter, ExceptionPasDeDiscussionEntreCesDeuxIndividu {
        if (lesConnecter.containsKey(from)){
            if (lesUtilisateurs.containsKey(to)){
                Utilisateur utilisateur_from = lesUtilisateurs.get(from);
                utilisateur_from.envoiMsg(to,msg);
                System.out.println("Message envoyer");

                Utilisateur utilisateur_to = lesUtilisateurs.get(to);
                utilisateur_to.envoiMsg(from,msg);
                System.out.println("Message recu");
            }else {
                throw new ExceptionUtilisateurInexistant();
            }
        }
        else{
            throw new ExceptionUtilisateurPasConnecter();
        }
    }


    public Collection<Discussion> recupererDiscussion (String utilisateur) throws ExceptionUtilisateurPasConnecter {
        if (lesConnecter.containsKey(utilisateur)){
            Utilisateur utilisateur_ = lesConnecter.get(utilisateur);
            System.out.println("Toutes les discussions recuperer :");
            return utilisateur_.recupererDiscussion().values();
        }
        else{
            throw new ExceptionUtilisateurPasConnecter();
        }
    }

}
