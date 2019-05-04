
import com.citeDeCulture.entities.Espace;
import com.citeDeCulture.entities.Event;
import com.citeDeCulture.entities.Reservation;
import com.citeDeCulture.sercicesImpl.ReservationServiceImpl;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mejri Dorra
 */
public class ConsoleTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Event e=new Event();
        Reservation r = new Reservation();
        ReservationServiceImpl rsi = new ReservationServiceImpl();
        //Date d= null;
        
        Date d= new Date(2019,04,23);
        for (int i = 0; i < rsi.findEvent(d).size() ;i++) {
           
        System.out.println(rsi.findEvent(d).get(i).getLibelle());
    }
    
}}
