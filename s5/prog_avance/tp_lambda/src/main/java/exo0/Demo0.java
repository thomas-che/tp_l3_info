package exo0;

public class Demo0 {
    public static void main(String[] args) {
        // lambda qui multiplie un entier par 2
        Fonction multiPar2 = (int i) -> i*2;

        System.out.println(multiPar2.appliquer(2));

        Fonction2 longeurChaine = (String s) -> s.length();

        System.out.println(longeurChaine.appliquer2("azerty"));

    }
}

interface Fonction{
    int appliquer(int i);
}

interface Fonction2{
    int appliquer2(String s);
}