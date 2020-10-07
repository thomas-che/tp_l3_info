package modele;

import execption.ExceptionDejaDiscussionEntreCesDeuxIndividu;
import execption.ExceptionPasDeDiscussionEntreCesDeuxIndividu;

import java.util.HashMap;
import java.util.Map;

public class Utilisateur {
    private String nom;
    private String pwd;

    private Map<String, Discussion> lesDiscution;

    public Utilisateur (String nom, String pwd){
        this.nom = nom;
        this.pwd = pwd;
        this.lesDiscution = new HashMap<>() ;
    }

    public String getNom() {
        return nom;
    }

    public String getPwd() {
        return pwd;
    }

    public void creeDiscussion(String title, String to, String msg) throws ExceptionDejaDiscussionEntreCesDeuxIndividu {
        String clef = to+nom;
        if (nom.compareTo(to) == -1){
            clef = nom+to;
        }
        String date = "10-1-2020";
        if (!lesDiscution.containsKey(clef)){
            lesDiscution.put(clef, new Discussion(title, nom, to, date, msg));
        }
        else{
            throw new ExceptionDejaDiscussionEntreCesDeuxIndividu();
        }
    }

    public void envoiMsg(String to, String msg) throws ExceptionPasDeDiscussionEntreCesDeuxIndividu {
        String clef = to+nom;
        if (nom.compareTo(to) == -1){
            clef = nom+to;
        }
        if(lesDiscution.containsKey(clef)){
            Discussion discussion = lesDiscution.get(clef);
            discussion.envoiMsg(nom,to,msg);
        }
        else {
            throw new ExceptionPasDeDiscussionEntreCesDeuxIndividu();
        }
    }



    public Map<String, Discussion> recupererDiscussion() {
        return lesDiscution;
    }
}
