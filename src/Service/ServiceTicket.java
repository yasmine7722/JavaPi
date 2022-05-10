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
public class ServiceTicket implements InterfaceCrud<Ticket> {
Connection cnx;
 private Statement ste;
 private ResultSet rs;

    public ServiceTicket() {
        
                cnx=DataSource.getInstance().getConn();

    }


    @Override
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

    @Override
    public void Modifier(Ticket t) {
        
          try {
            String req ="UPDATE ticket SET nom=? WHERE id=?";
            PreparedStatement ps= cnx.prepareStatement(req);
            ps.setString(1, t.getNom() );
             ps.setInt(2, t.getPrix() );
          ps.executeUpdate();
                        System.out.println("Ticket Modifié avec succès");

        } catch (SQLException ex) {
            Logger.getLogger(ServiceTicket.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    

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
    
    

   // @Override
    
//        public void delete(int id) {
//     
//         String requete = "DELETE FROM ticket WHERE id ="+id;
//        
//           try {
//            ste = cnx.createStatement();
//            ste.executeUpdate(requete);
//        } catch (SQLException ex) {
//            Logger.getLogger(ServiceEvent.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
        
         public void delete(Ticket e) {
     
         String requete = "DELETE FROM ticket WHERE id =" + e.getId();
        
           try {
            ste = cnx.createStatement();
            ste.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    

    @Override
    public List<Ticket> Afficher() {
        
         
         List<Ticket> events = new ArrayList<>();
        try {
            String req ="select * from ticket";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
               Ticket p = new Ticket();
               p.setId(rs.getInt(1));
               p.setNom(rs.getString(3));
               p.setPrix(rs.getInt(2));
           
               events.add(p);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());        }
            
        return events;
        
        
        
    }
    
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
    
    
    
    

    @Override
    public void Supprimer(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
