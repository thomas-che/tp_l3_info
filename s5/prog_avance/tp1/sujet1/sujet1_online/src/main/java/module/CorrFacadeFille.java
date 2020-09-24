package module;

import java.util.Collection;

public class CorrFacadeFille {

    private CorrDossier docCourrant;

    public CorrFacadeFille(String racine) {
        this.docCourrant = new CorrDossier(racine, null);
    }

    public void mkdir(String nomDossier) throws DocDejaExistant {
        docCourrant.mkdir(nomDossier);
    }

    public void touch(String nomFic, String content, String extention) throws FicDejaExistant {
        docCourrant.touch(nomFic,content,extention);
    }

    public Collection<Composant> ls(){
        return docCourrant.ls();
    }

    public void cd(String nomDoc) throws DocInexistant {
        if (nomDoc.equals("..")) {
            docCourrant = docCourrant.getParrent();
        }
        else {
            docCourrant = docCourrant.cd(nomDoc);
            System.out.println("dossier courant cd");
        }
    }

    public void rmFile(String nom){
        docCourrant.rmFile(nom);
    }


}
