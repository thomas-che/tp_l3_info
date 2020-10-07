package facade;

public interface FacadeMonoPoste {
    void ceatGame(String player1, String player2);

    void play (int x, int y);

    boolean isEndGame();

    void playAgain ();

    void endGame();

    /*String getWinner() throws GameNotFinish,*/

}
