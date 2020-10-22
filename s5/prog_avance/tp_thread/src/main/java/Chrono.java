public class Chrono implements Runnable{
    private int intervalle=1000;
    private String nom=null;

    private boolean continuer=true;

    public Chrono(int i, String nom){
        this.intervalle = i;
        this.nom= nom;
    }


    /*public void run() {
        for (int i = 0; i<11; i++) {
            System.out.println("nom = "+nom+" ; i ="+i);
            try {
                Thread.sleep(intervalle);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }*/

    public void setContinuer(Boolean b){
        continuer=b;
    }

    public void run() {
        int i =0;
        while (continuer) {
            System.out.println("nom = "+nom+" ; i ="+i);
            try {
                Thread.sleep(intervalle);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }
    }
}
