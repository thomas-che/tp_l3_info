package programme;

import modele.Item;
import module.FacadeOnline;

import java.util.List;

public class Programme2 {
    public static void main(String[] args) {
        FacadeOnline facadeOnline = new FacadeOnline();



        try {
            facadeOnline.inscription("Thomas");

            facadeOnline.mkdir("Thomas","Doc1");
            facadeOnline.mkdir("Thomas","Doc2");
            facadeOnline.touch("Thomas","Fic1","le contenu .....");
            System.out.println(facadeOnline.afficherEtat());
        }
        catch (Exception e){
            System.err.println("<ERROR> "+e.getMessage() );
        }
    }
}
