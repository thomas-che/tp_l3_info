import java.io.*;

public class Main {
    public static void main(String[] args) {
        Essai essai = new Essai();
        essai.setText("mon texte");
        essai.setId(12);

        ecrire(essai);
        Essai es = lire();
        System.out.println(es.toString());
    }

    public static Essai lire(){
        try {
            FileInputStream fis=new FileInputStream("serial.bin");
            ObjectInputStream ois=new ObjectInputStream(fis);
            Essai es = (Essai)ois.readObject();
            //System.out.println("Object : id="+es.getId()+" ; txt="+ es.getText());
            return es;
            /*ois.close();*/
        }
         catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public static void ecrire(Essai essai){
        try {
            // flux de bas niveau
            FileOutputStream fos=new FileOutputStream("serial.bin");
            // flus de plus haut niveaux
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(essai);
            oos.close();
        }
         catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
