package modele;

public class Partie {
    private Plateau lePlateau;
    private Joueur joueur1;
    private Joueur joueur2;
    private Joueur joueurCourrant;

    public Partie(String joueurName1, String joueurName2) {
        this.lePlateau = new Plateau();
        this.joueur1 = new Joueur(joueurName1, 1) ;
        this.joueur2 = new Joueur(joueurName2, 2);
        this.joueurCourrant = joueur1;
    }

    public void jouer(int x, int y) {

        if ( (x<0 && 2<x) || (y<0 && 2<y) ) {
            /*throw new CaseIndisponible;*/
            System.out.println("ERROR");
        }

        if (lePlateau.isCaseDispo(x, y) ){
            int pion = joueurCourrant.getPion();
            lePlateau.jouer(x,y,pion);
        }
        if(lePlateau.isWinner()){
            System.out.println("WINNER");
        }
    }

    public String printPlateau(){
        return lePlateau.printPlateau();
    }

}
