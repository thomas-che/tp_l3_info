import java.util.Scanner;

public class MainThread {
    public static void main(String[] args) {
        Chrono ch1 = new Chrono(100,"A");
        Thread th1 = new Thread(ch1);
        th1.start();

        Chrono ch2 = new Chrono(2000,"B");
        Thread th2 = new Thread(ch2);
        th2.start();

        new Scanner(System.in).nextLine(); //enter pr arrter

        ch1.setContinuer(false);
        ch2.setContinuer(false);
    }
}
