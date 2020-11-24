package exo2_predicat;

public class Predicat {
    public static void main(String[] args) {

        PredicatString nulle = (String s) ->  s==null;
        PredicatString vide = (String s) -> s.isEmpty(); // correction prof : "".equal(s)

        String s = null;
        boolean b = nulle.test(s);
        if (b){
            System.out.println("OUI s est null");
        }
        else{
            System.out.println("non s pas null");
        }

        String s2 = "et";
        boolean b2 = vide.test(s2);
        if (b2){
            System.out.println("OUI s est vide");
        }
        else{
            System.out.println("non s pas vide");
        }

        PredicatString nonNulle = nulle.not();
        PredicatString nonVide = vide.not();

        System.out.println("#######");
        s2 = "azerty";
        System.out.println(vide.test(s2));
        System.out.println(nonVide.test(s2));
        System.out.println("#######");

        System.out.println(nonNulle.test(s));



        PredicatString nonNulleEtNonVide = nonNulle.add(nonVide);

        System.out.println("\n#####");
        System.out.println(nonNulleEtNonVide.test(s));

    }
}


interface PredicatString{
    boolean test(String s);
    default PredicatString not(){
        return (String s) -> !this.test(s);
    };
    default PredicatString add(PredicatString p2){
        return (String s) -> this.test(s) && p2.test(s);
    };
}
