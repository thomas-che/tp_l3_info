package modele;

import java.util.ArrayList;
import java.util.Map;

public class Plateau {
    int lePlateau [][];

    public Plateau() {
        this.lePlateau = new int[3][3];
        for (int i = 0; i< 3; i++){
            for (int j = 0; j< 3; j++){
                lePlateau[i][j]=0;
            }
        }
    }


    public boolean isCaseDispo (int x, int y){
        if ( lePlateau[x][y] == 0 ){
            return true;
        }
        else {
            return false;
        }
    }

    public void jouer (int x, int y, int pion){
        lePlateau[x][y] = pion;
    }


    public boolean isWinner() {
        for (int i = 0; i< 3; i++){
            if( lePlateau[0][i] == lePlateau[1][i] && lePlateau[1][i]==lePlateau[2][i] ){
                /*test en colone*/
                return true;
            }
        }
        for (int i = 0; i< 3; i++){
            if( lePlateau[i][0] == lePlateau[i][1] && lePlateau[i][1]==lePlateau[i][2] ){
                /*test en line*/
                return true;
            }
        }

        if (lePlateau[0][0] == lePlateau[1][1] && lePlateau[1][1]==lePlateau[2][2] ){
            return true;
        }
        if (lePlateau[0][2] == lePlateau[1][1] && lePlateau[1][1]==lePlateau[2][0] ){
            return true;
        }
        return false;
    }

    public String printPlateau(){
        String str = "";
        for (int i = 0; i< 3; i++){
            for (int j = 0; j< 3; j++){
                str+=" "+lePlateau[i][j]+" | ";
            }
            str+="\n";
        }
        return str;
    }
}
