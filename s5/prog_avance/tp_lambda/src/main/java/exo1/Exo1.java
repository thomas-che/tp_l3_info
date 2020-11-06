package exo1;

import java.util.ArrayList;
import java.util.List;

public class Exo1 {

    public static void main(String[] args) {
        List<String> listeChaine = List.of("abc","def","ghi");

        FncStringList lbdaFin = (List<String> stringList) -> {
            List<String> copyStringList = new ArrayList<>(stringList); // on cree une copie car la List.of est non modifiable
            copyStringList.add("Fin"); // ajout a la fin
            return copyStringList; // on retunr le type que on veux
        };
        FncStringList lbdaDebut = (List<String> stringList) -> {
            List<String> copyStringList = new ArrayList<>(stringList);
            copyStringList.add(0,"Debut");
            return copyStringList;
        };

        // une application de lambda sur une lambda
        FncStringList lbdaDebutFin = (List<String> stringList) -> lbdaFin.apply(lbdaDebut.apply(stringList));

        FncPrint lbdaPrint = (String str) -> System.out.println(str);

        // test
        System.out.println(lbdaDebutFin.apply(listeChaine));
        lbdaPrint.apply(listeChaine.toString());

        for (String s : listeChaine){ // pr afficher 1 a 1 les element de la liste
            lbdaPrint.apply(s);
        }

    }
}

interface FncStringList {
    List<String> apply(List<String> stringList);
}

interface FncPrint{
    void apply(String str);
}




