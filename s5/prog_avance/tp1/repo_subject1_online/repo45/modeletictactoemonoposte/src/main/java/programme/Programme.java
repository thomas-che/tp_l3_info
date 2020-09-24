package programme;

import modele.*;

import java.util.Objects;
import java.util.Scanner;

public class Programme {


    private final static Scanner scanner = new Scanner(System.in);

    private static void vueInitiale(FacadeTicTacToeLocal facadeTicTacToeLocal) {


        System.out.println("----------------- " +
                "Le Tic tac toe du futur des temps anciens " +
                "-----------------");

        System.out.println("Saisir les deux joueurs : ");
        System.out.println("Createur ? ");
        String createur = scanner.next();
        System.out.println("invite ? ");
        String invite = scanner.next();
        try {
            facadeTicTacToeLocal.creerPartie(createur,invite);
            vueJeu(facadeTicTacToeLocal);
        } catch (PseudosIncorrectsException e) {
            System.err.println("Les pseudos doivent être non vides et d'au moins 3 caractères... et différents l'un de l'autre...");
            vueInitiale(facadeTicTacToeLocal);
        }


    }

    private static String getCase(Integer x) {
        if (Objects.isNull(x)) {
            return " ";
        }
        switch (x) {
            case 0 : return "x";
            case 1: return "o";
        }
        return " ";
    }

    private static void afficherPlateau(FacadeTicTacToeLocal facadeTicTacToeLocal) {
        Plateau plateau = facadeTicTacToeLocal.getPlateau();
        Integer[][] matrice = plateau.getPlateau();

        String resultat="";
        for (int i = 0; i<3;i++) {
            resultat+="|";
            for(int j = 0;j<3;j++) {
                resultat += getCase(matrice[i][j])+"|";

            }
            resultat +="\n";

        }
        System.out.println(resultat);

    }

    private static void vueJeu(FacadeTicTacToeLocal facadeTicTacToeLocal) {

        while (!facadeTicTacToeLocal.isPartieTerminee()) {
         afficherPlateau(facadeTicTacToeLocal);
         System.out.println("Au tour de "+facadeTicTacToeLocal.getJoueurCourant()+" !");
         System.out.println("Saisir les coordonnées du coup (x,y) :");
         int x = scanner.nextInt();
         int y = scanner.nextByte();
            try {
                facadeTicTacToeLocal.jouerCoup(facadeTicTacToeLocal.getJoueurCourant(),x,y);
            } catch (TricheurException e) {
                System.err.println("Erreur qui sert à rien et qui ne sera jamais levée...");

            } catch (CoupInvalideException e) {
                System.err.println("Le coup est en dehors des limites... Try again...");
            } catch (CoupDejaJoueException e) {
                System.err.println("Le coup a déjà été joué... Essaye encore...");
            }
        }

        System.out.println("Partie terminée...");
        try {
            System.out.print("Le vainqueur est :"+facadeTicTacToeLocal.getGagnant());
        } catch (PasDeGagnantException e) {
            System.out.println("Pas de vainqueur...");
        }
    }


    public static void main(String[] args) {
        FacadeTicTacToeLocal facadeTicTacToeLocal = new FacadeTicTactToeImpl();
        vueInitiale(facadeTicTacToeLocal);

    }
}
