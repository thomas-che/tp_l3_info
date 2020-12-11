package fichiers;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class Fichier_mcdo {
    public static void main(String[] args) throws IOException {
        // demare a la racine du projet, donc lien commence a la racine
        // juste pour afficher les lignes
/*        Files.lines(Paths.get("/home/thomas/Documents/tp_l3_info/s5/prog_avance/tp_lambda/src/main/resources/mcdo.csv"), StandardCharsets.UTF_8)
                .map(line->MacDo.toMacDo(line))
                .forEach(System.out::println); // on fait un groupBy ville et un max*/
        // on veut recuperer la ville avec le plus de mcdo
        Stream<MacDo> macDoStream = Files.lines(Paths.get("/home/thomas/Documents/tp_l3_info/s5/prog_avance/tp_lambda/src/main/resources/mcdo.csv"), StandardCharsets.UTF_8)
                .map(line->MacDo.toMacDo(line));
        Map<String,Integer> compteParVille = macDoStream.collect(
                Collectors.toMap(
                        macDo -> macDo.getVilleEtat(),
                        macDo -> 1,
                        (compte1, compte2) -> compte1+compte2
                )
        );
        var maxCpt = compteParVille.values().stream().max(Integer::compareTo);
        if (maxCpt.isEmpty()){
            throw new RuntimeException("pas de max...");
        }
        Integer max = maxCpt.get();
        var resultat = compteParVille.entrySet().stream().filter(entry -> entry.getValue().equals(max)).collect(
                Collectors.toList()
        );
        System.out.println("res = "+resultat);

        // ou avec un group by
        /*var  compteParVille = macDoStream2.collect(
                Collectors.gourpingBy(
                        MacDo::getVilleEtat,
                        Collectors.counting()
                )
        );*/
    }
}

class MacDo{
    private String ville;
    private String etat;

    public MacDo(String ville, String etat) {
        this.ville=ville;
        this.etat=etat;
    }

    public String getVille() {
        return ville;
    }

    public String getEtat() {
        return etat;
    }

    public String getVilleEtat() {
        return ville+","+etat;
    }

    public static MacDo toMacDo(String enCsv){
        String ville = enCsv.split(",")[5];
        String etat = enCsv.split(",")[6];
        return new MacDo(ville,etat);
    }

    @Override
    public String toString() {
        return "MacDo{" +
                "ville='" + ville + '\'' +
                ", etat='" + etat + '\'' +
                '}';
    }
}
