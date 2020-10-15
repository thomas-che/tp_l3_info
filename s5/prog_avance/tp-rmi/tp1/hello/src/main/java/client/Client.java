package client;

import interfaces.Hello;
import interfaces.Message;
import serveur.HelloImpl;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {


        try{
            String ip_deb="192.168.46.";
            int ip_suite = 0;
            String ip ="";

            for (int i = 31; i<70; i++){
                ip=ip_deb+i;
                ;

                try{
                    Registry reg = LocateRegistry.getRegistry(ip);
                    Hello h = (Hello) reg.lookup("HelloService"); //HelloService
                    System.out.println(ip);
                    // String result = h.hello();
                    Message result = h.hello();
                    System.out.println("\n\t\t\t ==> "+result.getMsg() +" <=\n");
                }
                catch ( ConnectIOException | ConnectException | UnmarshalException | NotBoundException | ServerException e){
                    continue;
                }


            }

            System.out.println("\n\n\n ########### local");

            Registry reg = LocateRegistry.getRegistry("localhost"); // localhost


            Hello h = (Hello) reg.lookup("HelloService");

            /*String result = h.hello();*/
            Message result = h.hello();
            System.out.println(result.getMsg());

        }
        catch (RemoteException e){
            e.printStackTrace(); // excption du Registry
        } catch (NotBoundException e) {
            e.printStackTrace(); // reg.lookup
        }
    }
}
