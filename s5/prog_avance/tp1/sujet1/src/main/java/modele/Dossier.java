package modele;



import java.lang.reflect.Array;
import java.util.*;

public class Dossier{
    private String nom;
    private List<Fichier> lesFic;
    private List<Dossier> lesDoc;

    public Dossier(String nom){
        this.nom = nom;
        this.lesFic = new ArrayList<Fichier>() ;
        this.lesDoc = new ArrayList<Dossier>() ;
    }

    public String getFichier(String nom){
        for (Fichier f : lesFic){
            if (f.getNom().equals(nom)){
                return f.toString();
            }
        }
        return null;
    }


    public String listerDossier(){
        String str = "";

        List<String> nomDoc = new ArrayList<>();
        for (Dossier d : lesDoc){
            nomDoc.add(d.getNom());
        }
        List<String> nomFic = new ArrayList<>();
        for (Fichier f : lesFic){
            nomFic.add(f.getNom());
        }

        str+="Dossier courrant ="+this.nom+" ; \n";
        str+="Les sous dossier : "+nomDoc.toString()+" ; \n";
        str+="Les fichiers : "+nomFic.toString()+" ; \n";
        return str;
    }


    public void creatDoc(String nom){
        Dossier newDoc = new Dossier(nom);
        lesDoc.add(newDoc);
    }

    public void creatFic(String nom, String contenu, String extention){
        Fichier newFic = new Fichier(nom,contenu,extention);
        lesFic.add(newFic);
    }

    public Dossier changeDoc(String nomDoc){
        for (Dossier d : lesDoc){
            if(d.getNom().equals(nomDoc)){
                return d;
            }
        }
        return null;
    }

    public String getNom() {
        return nom;
    }
}
