package logs;

import execption.NomTropLongExecption;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.*;

public class MaListe {
    private Collection<String> personnes = new ArrayList<String>();

    public MaListe(){
        // cree le loger 1 seul fois
        Logger logger = Logger.getLogger("logs");
        try {
            // cree un handler trace.txt
            Handler handler = new FileHandler("trace.txt");
            // ajout de cet handler au logger
            logger.addHandler(handler);

            // changer le format du handler en mode classe anonyme
            Formatter formateur = new Formatter(){
                @Override
                public String format(LogRecord logRecord) {
                    return (logRecord.getLevel()+" : "+logRecord.getMessage()+" \n");
                }
            };
            // changer le formateur de notre handler
            handler.setFormatter(formateur);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ajout(String str) throws NomTropLongExecption {

        // logger de basse rustique
        /*Logger logger = Logger.getAnonymousLogger();*/

        // logger plus propre
        //Logger logger = Logger.getLogger("");

        // changer le niveau du logger au plus fin
        //logger.setLevel(Level.FINEST);

        // changer tous les handler avec le filtre le plus fin
        //for (Handler h : logger.getHandlers()){
        //    h.setLevel(Level.FINEST);
        //}

        // on prend le logger definit dans le package = "logs"
        Logger logger = Logger.getLogger("logs");

        if( 20 < str.length()){
            logger.warning("nom trop log ! "+str);
            throw new NomTropLongExecption();
        }
        else{
            // afficher le msg
            //logger.log(Level.INFO,"ajout de "+str); // ou logger.info("ajout de "+str);
            //logger.severe("JE SUIS SEVERE");
            //logger.finest("je suis tres souple");
            personnes.add(str);
        }

    }
}
