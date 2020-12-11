package exo4_le_compte_est_bon;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class LeCompteEstBon {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "hello", "lambda");

        System.out.println(compter(list,"hello"));
    }

    public static long compter(Collection<String> list, String mot){
        return list.stream().filter(s -> s.equals(mot)).count();
    }
}
