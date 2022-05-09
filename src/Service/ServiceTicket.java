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
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.ResultSet;



/**
 *
 * @author toshiba
 */
public class ServiceTicket  {
Connection cnx;
 private Statement ste;
 private ResultSet rs;

    public ServiceTicket() {
        
                cnx=DataSource.getInstance().getConn();

    }

// Ajouter
   
    public void Ajouter(Ticket t) {
        
        
         
            String req = "insert into ticket(nom,prix)"
                    +"values('"+t.getNom()+"','"+t.getPrix()+"')";
             try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Ticket ajouté avec succès");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        
        }
    }

 
   
    
    //Modifier
    

         public void updateTicket(Ticket t ,String nom ,int prix ){
        try {
            String requete4 =" UPDATE ticket SET " + " nom = ?, prix = ? WHERE id = " +t.getId() ;
            PreparedStatement pst =cnx.prepareStatement(requete4);
                      //  pst.setInt(5, id);
                        pst.setString(1, nom);
                        pst.setInt(2, prix);
                  
                       
                        
            pst.executeUpdate();
            System.out.println("votre fournisseur est modifiee");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    

  
    
//suprimer
        
         public void delete(Ticket e) {
     
         String requete = "DELETE FROM ticket WHERE id =" + e.getId();
        
           try {
            ste = cnx.createStatement();
            ste.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    

  
   //afficher 
    
     public ObservableList<Ticket>affichertick(){
       ObservableList<Ticket> myList = FXCollections.observableArrayList();
        try {
            
            String requete3 = "SELECT * FROM ticket";
            Statement st = cnx.createStatement();
           ResultSet rs = st.executeQuery(requete3);
           while(rs.next()){
               Ticket P = new Ticket();
                P.setId(rs.getInt(1));
               P.setNom(rs.getString("nom"));
              
                P.setPrix(rs.getInt("prix"));
               
               myList.add(P);
           }
           
           
           
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
        
    }
    
    
    
    

   


   public Ticket getTicket(int id) {

   String requete = "select * FROM ticket WHERE id = '" + id + "'";
        Ticket cr = new Ticket();
        
           try {
            ste = cnx.createStatement();
                       rs= ste.executeQuery(requete);
            while (rs.next()) { 
      
                
                 cr.setId(id);
                 cr.setNom(rs.getString("nom"));
                 cr.setPrix(rs.getInt("prix"));
                 
                 
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceTicket.class.getName()).log(Level.SEVERE, null, ex);
        }
            return cr;
   
   
   }
        
}
