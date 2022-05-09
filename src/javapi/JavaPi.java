/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapi;
import Entity.Event;
import Entity.Ticket;
import Entity.ProgNutri;
import Service.ServiceEvent;
import Service.ServiceTicket;
import Service.ServiceNutri;
import Util.DataSource;
import java.time.LocalDateTime;
/**
 *
 * @author toshiba
 */
public class JavaPi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        LocalDateTime now = LocalDateTime.now();
        
        
        DataSource db = DataSource.getInstance();
        System.out.println(db);
        ServiceTicket servReg = new ServiceTicket();
       
//Ajouter un programme nutrition






//Event e = new Event(568,"dhia");
  //  ServiceEvent ps = new ServiceEvent();
   // ps.Ajouter(e);
       
//Modifier un programme nutrition      
       
      // ProgNutri p = new ProgNutri(14,"proteine");
       // ServiceNutri ps = new ServiceNutri();
       // ps.Modifier(p);
       
       ///// update prog
       // ServiceTicket ps = new ServiceTicket();
        //ps.updateticket(8,5,"ghj");
    
         //servReg.updateTicket(9, 9,"youu");

        
        
        /////// delete
     // ServiceTicket ps = new ServiceTicket();
      //ps.delete(8);
      
//Afficher nutrition
      // ServiceEvent ps = new ServiceEvent();
      //System.out.println(ps.Afficher());
       
       
       //Ajouter un event
     //  Ticket t = new Ticket("hhhh",88);
//      Event p = new Event("hhhh","hhdhd","2000-04-11",15);
//       ServiceEvent ps = new ServiceEvent();
//       ps.Ajouter(p);
//       
       
    }
        
        
        
        
        // TODO code application logic here
 }
    

