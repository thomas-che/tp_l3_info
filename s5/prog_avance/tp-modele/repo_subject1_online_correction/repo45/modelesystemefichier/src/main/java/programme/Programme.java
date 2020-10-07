package programme;

import facade.Facade;
import modele.DejaPresentException;
import modele.Item;
import modele.NotFoundException;

import java.util.List;

public class Programme {


    public static void main(String[] args) throws DejaPresentException, NotFoundException {

        Facade facade = new Facade();
        facade.creerDossier("home");
        facade.creerDossier("usr");
        facade.cd("usr");
        facade.creerFichier("Readme.txt","babar");
        facade.cd("..");
        List<Item> x = facade.ls();
        for (Item y : x) {
            System.out.print(y.getInfo() +"\n");
        }
    }
}
