package demoMap;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DemoMap {
    public static void main(String[] args) {
        String phrase = "le TP de demain du groupe 2 aura lieu de 13h30 à 16h30, au lieu de l'horaire affiché dans ADE .";


        Map<String,Integer> result = Arrays.stream(phrase.split(" ")).collect(Collectors.toMap(mot-> mot.substring(0,1) , mot->1  , (val1, val2)->val1+val2));
        System.out.println(result);

        Map<Character, List<String>> mots = Arrays.stream(phrase.split(" ")).collect(Collectors.toMap(
                mot->mot.charAt(0),
                mot-> {
                    List<String> newListe = new ArrayList<>();
                    newListe.add(mot);
                    return newListe;
                },
                (l1,l2)-> {
                    List<String> l3 = new ArrayList<>();
                    l3.addAll(l1);
                    l3.addAll(l2);
                    return l3;
                }
        ));
        System.out.println("Mots = "+mots);
        // plus rapide avec groupingBy
        Map<Character, List<String>> mots2 = Arrays.stream(phrase.split(" ")).collect(
                Collectors.groupingBy(
                        mot->mot.charAt(0)
                )
        );
        System.out.println("Mots = "+mots2);



        Map<Character, Set<String>> motsSet = Arrays.stream(phrase.split(" ")).collect(Collectors.toMap(
                mot->mot.charAt(0),
                mot-> Set.of(mot),
                (set1,set2)-> {
                    Set<String> set3 = new HashSet<>();
                    set3.addAll(set1);
                    set3.addAll(set2);
                    return set3;
                }
        ));
        System.out.println("Mots = "+motsSet);
        // plus rapide avec groupingBy
        Map<Object, Set<String>> motsSet2 = Arrays.stream(phrase.split(" ")).collect(
                Collectors.groupingBy(
                        mot->mot.charAt(0),
                        Collectors.toSet()
                )
        );
        System.out.println("Mots = "+motsSet2);
    }
}
