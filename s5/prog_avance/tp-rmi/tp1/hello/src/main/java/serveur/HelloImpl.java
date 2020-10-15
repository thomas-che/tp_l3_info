package serveur;

import interfaces.Hello;
import interfaces.Message;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class HelloImpl implements Hello {

    SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
    Date date = new Date(System.currentTimeMillis());
    /*System.out.println(formatter.format(date));*/
    @Override
    public Message hello() throws RemoteException {
        Message m = new Message();
        m.setMsg("\nfrom : THOMAS 192.168.46.42\nDatetime : "+ formatter.format(date) +"\nbody : my message is empty ;)\nBye...\n");
        return m;
    }

   /* public String hello() throws RemoteException {
        return "\nTHOMAS 46.42\nYou call server hello, it respond : \n\n\tHello world \n";
    }*/

}
