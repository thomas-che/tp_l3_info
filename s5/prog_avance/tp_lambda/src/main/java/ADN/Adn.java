package ADN;

import com.sun.source.doctree.SeeTree;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Adn {
    public static void main(String[] args) {
        String chaine = "ACTGGGACCTAGA";

        // lanbda complemntaire : A->T, T->A, C->G, G->C
        Fonction charComplementaire = (String c) -> c.equals("A") ? "T" : c.equals("T") ? "A" : c.equals("C") ? "G" : "C";
        System.out.println("char complmentaire = " + charComplementaire.appliquer("A"));

        // avec une fonction ; correction prof
        Function<String, String> complementaire =
                lettre -> {
                    switch(lettre){
                        case "A": return "T";
                        case "T": return "A";
                        case "C": return "G";
                        case "G": return "C";
                        default: throw new RuntimeException("lettre non valide");
                    }
                };
        System.out.println("le complemaitaire : "+complementaire.apply("A"));

        String adnComp = Arrays.stream(chaine.split("")).map(str -> complementaire.apply(str) ).collect(Collectors.joining());
        System.out.println(adnComp);

        // cb de letre A
        Stream<String> lettreAdnA = Arrays.stream(chaine.split(""));
        long nbA = lettreAdnA.filter(lettre -> lettre.equals("A")).count();
        System.out.println("Nb de A dans la chaine d'adn :"+nbA);

        // generer une chaire aleatoire d'adn
        Map<Long, String> toATCG = Map.of(
                0L, "A", 1l, "C", 2l, "T", 3L, "G"
        );
        String adnAleatoire = ThreadLocalRandom
                .current()
                .longs(0,4)
                .boxed()
                .map(nb -> toATCG.get(nb))
                .limit(10000)
                .collect(Collectors.joining());

        System.out.println("Chaine aleatoire : "+adnAleatoire);

        // grouper par lettres
        var nbLetreAleatoire = Arrays.stream(adnAleatoire.split(""))
                .collect(Collectors
                        .groupingBy(
                                base -> base,
                                Collectors.counting()
                        )
                );
        System.out.println(nbLetreAleatoire);
    }
}
interface Fonction {
    String appliquer( String c);
}