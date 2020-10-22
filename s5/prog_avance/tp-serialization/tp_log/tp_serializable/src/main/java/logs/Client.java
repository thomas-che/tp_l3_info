package logs;

import execption.NomTropLongExecption;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {
    public static void main(String[] args) {

        // defini le logger general pr le package logs
        Logger super_logger = Logger.getLogger("");
        // ici on peut changer le niv et juste 1 fois
        super_logger.setLevel(Level.WARNING);
        for (Handler h : super_logger.getHandlers()){
            h.setLevel(Level.FINEST);
        }

        MaListe maListe = new MaListe();

        try {
            maListe.ajout("mouloud");
            maListe.ajout("mouloudazejpgaegfauyzgefjayzfekuafzejhfa");
        } catch (NomTropLongExecption nomTropLongExecption) {
            nomTropLongExecption.printStackTrace();
        }

    }
}
