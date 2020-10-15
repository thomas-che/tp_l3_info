package client;

import java.sql.*;

public class ConnexionBD {

    // premiere partie : connection simpple a la bdd
   /* public static void main(String[] args){
        try{
            Connection c = DriverManager.getConnection("jdbc:mysql://dbhost:3306/bd_o2180812","o2180812","thomas");
            Statement s1 = c.createStatement();
            s1.executeUpdate("INSERT INTO test VALUES (\"michelle\");");
            Statement s = c.createStatement();
            ResultSet rs =s.executeQuery("SELECT * FROM test;");
            while (rs.next()){
                System.out.println(rs.getString(1));
            }
        }
        catch (Exception e){
            System.out.println("ERREUR");
            e.printStackTrace();
        }


    }*/

    // cree une inuque connexion avec le static
    private static Connection connecxion=null;

    /**
     * Si premier fois que apple cette methode alors cree la co avec DriverManager.getConnection
     * Sinon retun juste la co
     * @return la connecxion a la bdd
     */
    public static Connection getConnecxion(){
        if(connecxion == null){
            try {
                connecxion = DriverManager.getConnection("jdbc:mysql://dbhost:3306/bd_o2180812","o2180812","thomas");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return connecxion;
    }

    public ConnexionBD() {
        getConnecxion();
    }



}
