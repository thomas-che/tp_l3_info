package programme;

import modele.Partie;

public class Programme {
    public static void main(String[] args) {
        Partie p = new Partie("Thomas","Mathieu");
        System.out.println(p.printPlateau());
    }
}
