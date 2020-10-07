package module;

import module.execption.DejaPresentException;
import module.execption.NotFoundException;
import module.execption.RenommageImpossible;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Dossier implements Item {

    private static Logger logger = Logger.getLogger(Dossier.class);
    private List<Item> dossiers;
    private String nom;
    private Dossier pere;

    public Dossier(String nom, Dossier pere) {
        this.nom = nom;
        this.pere = pere;
        this.dossiers = new ArrayList<>();
    }


    public List<Item> getDossiers() {
        return dossiers;
    }

    public void setDossiers(List<Item> dossiers) {
        this.dossiers = dossiers;
    }

    @Override
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String getInfo() {
        return "Dossier "+getNom()+" contient "+ dossiers.size() + " element(s)";
    }

    public Dossier getPere() {
        return pere;
    }

    public void setPere(Dossier pere) {
        this.pere = pere;
    }


    public Dossier cd(String nom) throws NotFoundException {
        for (Item x : this.dossiers) {
            if (x.getNom().equals(nom)) {
                if ( x instanceof Dossier) {
                    return (Dossier)x;
                }
            }
        }

        throw new NotFoundException();
    }
    public List<Item> ls () {
        return this.dossiers;
    }

    public void renommer(String nomActuel, String nomFutur) throws RenommageImpossible {
        for (Item x : this.dossiers ) {
            if (x.getNom().equals(nomFutur)) {
                throw new RenommageImpossible();
            }
        }
        for (Item x : this.dossiers) {
            if (x.getNom().equals(nomActuel)) {
                x.setNom(nomFutur);
            }
        }
    }



    public void addItem(Item item) throws DejaPresentException {
        for (Item x : this.dossiers) {
            if (x.getNom().equals(item.getNom())) {
                throw new DejaPresentException();
            }
        }

        this.dossiers.add(item);

    }


}
