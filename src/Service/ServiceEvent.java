/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Event;
import Entity.Ticket;
import Util.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.LocalDateTime;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Service.ServiceTicket;

/**
 *
 * @author toshiba
 */
public class ServiceEvent  {
Connection cnx;
 private Statement ste;

    public ServiceEvent() {
        
                cnx=DataSource.getInstance().getConn();

    }


 //Ajouter
    public void Ajouter(Event e) {
//          LocalDateTime now = LocalDateTime.now();
//                 e.setDate(now );

          String req = "insert into events(nom,date,ticket_id,descrip)"
                    +"values('"+e.getNom()+"','"+e.getDate()+"','"+e.getTicket_id()+"','"+e.getDescription()+"')";
             try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Event ajouté avec succès");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        
        }
    }

  
 //Supprimer
    
    
       public void delete(Event e) {
     
         String requete = "DELETE FROM events WHERE id =" + e.getId();
        
           try {
            ste = cnx.createStatement();
            ste.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
       
       

 

//Afficher    
    
    public ObservableList<Event>afficherEvent(){
       ObservableList<Event> myList = FXCollections.observableArrayList();
        try {
            
            String requete3 = "SELECT * FROM events";
            Statement st = cnx.createStatement();
           ResultSet rs = st.executeQuery(requete3);
           while(rs.next()){
             ServiceTicket ts = new ServiceTicket();
              Ticket ticket= new Ticket(); 


 ticket =  ts.getTicket(rs.getInt("ticket_id"));              
               
               
               Event P = new Event();
                P.setId(rs.getInt(1));
               P.setDescription(rs.getString("Descrip"));
              
                P.setNom(rs.getString("nom"));
               P.setDate(rs.getDate("date"));
               P.setTicket_id(rs.getInt("ticket_id"));
               
               myList.add(P);
           }
           
           
           
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
        
    }
    
    //Modifier
    
    
     public void updateev(Event e, String nom,Date date ,String description,int ticket_id){
        try {
            String requete4 =" UPDATE events SET " + " nom = ?, date = ? , Descrip=?, ticket_id=? WHERE id = " + e.getId() ;
            PreparedStatement pst =cnx.prepareStatement(requete4);
                      //  pst.setInt(5, id);
                        pst.setString(1, nom);
                        pst.setString(3, description);
                         pst.setDate(2, date);
                         pst.setInt(4, ticket_id);
                     
                     
                       
                        
            pst.executeUpdate();
            System.out.println("votre event est modifiee");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    

        
}
