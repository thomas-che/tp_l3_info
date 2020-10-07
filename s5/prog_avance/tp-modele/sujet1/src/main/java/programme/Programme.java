package programme;

import modele.*;

public class Programme {
    public static void main(String[] args) {
       /*FacadeFileSys facade = new FacadeFileSys("/");
       * facade.mkdir("doc1");
       * facade.cd("doc1");
       * facade.cd("..");
       * */

        CorrFacadeFille facable = new CorrFacadeFille("/");

        try {
            facable.mkdir("doc1");
            facable.mkdir("doc 2");
/*            facable.mkdir("doc1");*/


            facable.touch("fic1","le contenu",".txt");
            facable.touch("fic2","le contenu",".txt");
            facable.touch("fic1","le contenu",".java");
            System.out.println("ls ####");
            for (Composant c : facable.ls()){
                if(c instanceof CorrFichier){
                    System.out.println(c.getNom()+((CorrFichier) c).getExtention());
                }
                else{
                    System.out.println(c.getNom());
                }

            }
            System.out.println("ls ####");
            /*facable.touch("fic1","le contenu",".txt");*/
            facable.cd("doc1");
            System.out.println("\n 2 ls ####");
            facable.mkdir("doc3");
            facable.touch("fic1","le contenu",".txt");
            facable.ls();
            System.out.println(" 2 ls #### \n");

        } catch ( Exception e ) {
            System.err.println("<ERROR> "+e.getMessage() );
        }

    }
}
