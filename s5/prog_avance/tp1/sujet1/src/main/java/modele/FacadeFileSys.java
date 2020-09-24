package modele;

import java.util.Objects;

public class FacadeFileSys {
    private Dossier racine;
    private Dossier dossierCourrant;

    public void FacadeFileSys (Dossier racine){
        this.racine = racine;
        this.dossierCourrant = racine;
    }

    public String ls(){
        return dossierCourrant.listerDossier();
    }

    public String getFichier(String nomFichier){
        return this.dossierCourrant.getFichier(nomFichier);
    }

    public void cd(String nomDoc){
        Dossier newDocCourrant = dossierCourrant.changeDoc(nomDoc);
        if ( Objects.isNull(newDocCourrant) ){
            this.racine = this.dossierCourrant;
            this.dossierCourrant = newDocCourrant;
        }
        else {
            System.out.println("pb nom du dossier est incorrect");
        }
    }


    public void mkdirDoc(String nom){
        dossierCourrant.creatDoc(nom);
    }

    public void touch(String nom, String contenu, String extention){
        dossierCourrant.creatFic(nom,contenu,extention);
    }

}
