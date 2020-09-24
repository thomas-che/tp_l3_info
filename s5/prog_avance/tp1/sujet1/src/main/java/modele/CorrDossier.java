package modele;

import java.util.ArrayList;
import java.util.Collection;

public class CorrDossier implements Composant{
    private String nom;
    private CorrDossier parrent;
    private Collection<CorrDossier> lesDoc;
    private Collection<CorrFichier> lesFic;

    public CorrDossier(String nom, CorrDossier racine) {
        this.nom = nom;
        this.parrent = racine;
        lesDoc = new ArrayList<>();
        lesFic = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public CorrDossier getParrent() {
        return parrent;
    }

    public void mkdir(String docNom) throws DocDejaExistant {
        for(CorrDossier d :lesDoc){
            if(d.getNom().equals(docNom)){
                throw new DocDejaExistant(docNom);
            }
        }
        this.lesDoc.add(new CorrDossier(docNom, this.parrent));
    }


    public Collection<Composant> ls() {
        Collection<Composant> res = new ArrayList<>();
        res.addAll(this.lesDoc);
        res.addAll(this.lesFic);
        return res;
    }

    public void touch(String nomFic, String content, String extention) throws FicDejaExistant {
        for(CorrFichier f :lesFic){
            if(f.getNom().equals(nomFic) && f.getExtention().equals(extention)){
                throw new FicDejaExistant(nomFic);
            }
        }
        this.lesFic.add(new CorrFichier(nomFic,content,extention));
    }

    public CorrDossier cd(String nomDoc) throws DocInexistant {

        if("..".equals(nomDoc)){
            return this.parrent;
        }

        for(CorrDossier d :lesDoc){
            if(d.getNom().equals(nomDoc)){
               return d;
            }
        }
        throw new DocInexistant(nomDoc);
    }

    public void rmFile(String nom) {
        for(CorrFichier f :lesFic){
            if(f.getNom().equals(nom)){
                lesFic.remove(f);
            }
        }
    }
}
