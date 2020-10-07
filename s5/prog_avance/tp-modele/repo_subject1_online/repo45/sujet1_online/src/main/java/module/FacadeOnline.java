package module;

import modele.DejaPresentException;
import modele.Item;
import modele.NotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class FacadeOnline {

    private ArrayList<User> listUser;

    public FacadeOnline() {
        this.listUser = new ArrayList<User>();
    }

    public void inscription (String nomUser){
        listUser.add(new User(nomUser));
    }

    public void deconection (String nomUser) throws UserInextant {
        for (User usr : listUser){
            if(usr.getNom().equals(nomUser)){
                usr.deconection();
            }
        }
        throw new UserInextant(nomUser);
    }

    public void connection (String nomUser) throws UserInextant {
        for (User usr : listUser){
            if(usr.getNom().equals(nomUser)){
                usr.connection();
            }
        }
        throw new UserInextant(nomUser);
    }

    public void supprimer (String nomUser) throws UserInextant {
        for (User usr : listUser){
            if(usr.getNom().equals(nomUser)){
                listUser.remove(usr);
                /*usr.supprimer();*/
                System.out.println("SUPRIMER USER");
            }
        }
        throw new UserInextant(nomUser);
    }

    public String afficherEtat (){
        String etat = "Liste des User : \n";
        String connect = "Non";
        for (User usr : listUser){
            connect = "Non";
            if (usr.isConnect()){
                connect = "Oui";
            }
            etat+="\tnom: "+usr.getNom()+" ; connect? "+connect+"\n";

            List<Item> x = usr.getFacadeFileSys().ls();
            for (Item y : x) {
                etat+="\t\t ->"+y.getInfo() +"\n";
            }
        }
        return etat;
    }


    /*
        Partie avec aide du prof
     */

    public void mkdir(String nomUser, String nomDossier) throws UserInextant, DejaPresentException {
        boolean isUserKnow = false;
        for (User usr : listUser){
            System.out.println(usr.getNom());
            if(usr.getNom().equals(nomUser)){
                usr.getFacadeFileSys().creerDossier(nomDossier);
                isUserKnow = true;
            }
        }
        if (!isUserKnow){
            throw new UserInextant(nomUser);
        }

    }

    public void touch(String nomUser, String nomFichier, String contenu) throws UserInextant, DejaPresentException {
        boolean isUserKnow = false;
        for (User usr : listUser){
            if(usr.getNom().equals(nomUser)){
                usr.getFacadeFileSys().creerFichier(nomFichier, contenu);
                isUserKnow = true;
            }
        }
        if (!isUserKnow){
            throw new UserInextant(nomUser);
        }
    }


    public void cd(String nomUser, String cible) throws UserInextant, NotFoundException {
        boolean isUserKnow = false;
        for (User usr : listUser){
            if(usr.getNom().equals(nomUser)){
                usr.getFacadeFileSys().cd(cible);
                isUserKnow = true;
            }
        }
        if (!isUserKnow){
            throw new UserInextant(nomUser);
        }
    }

    public Collection<Item> ls (String nomUser) throws UserInextant {
        boolean isUserKnow = false;
        for (User usr : listUser){
            if(usr.getNom().equals(nomUser)){
                isUserKnow = true;
               return usr.getFacadeFileSys().ls();
            }
        }
        if (!isUserKnow){
            throw new UserInextant(nomUser);
        }
    return null;
    }

}
