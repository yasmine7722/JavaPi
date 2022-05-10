/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Article;
import Entity.Categorie;
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
public class ServiceCategorie implements InterfaceCrud<Categorie> {
Connection cnx;
 private Statement ste;
 private ResultSet rs;

    public ServiceCategorie() {
        
                cnx=DataSource.getInstance().getConn();

    }


    @Override
    public void Ajouter(Categorie t) {
        
        
         
            String req = "insert into categorie(nom)"
                    +"values('"+t.getNom()+"')";
             try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Categorie ajouté avec succès");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        
        }
    }

    @Override
    public void Modifier(Categorie t) {
        
          try {
            String req ="UPDATE categorie SET nom=? WHERE id=?";
            PreparedStatement ps= cnx.prepareStatement(req);
            ps.setString(1, t.getNom() );
          ps.executeUpdate();
                        System.out.println("Blog Modifié avec succès");

        } catch (SQLException ex) {
            Logger.getLogger(ServiceCategorie.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    

         public void updateCategorie(Categorie t ,String nom ){
        try {
            String requete4 =" UPDATE categorie SET " + " nom = ? WHERE id = " +t.getId() ;
            PreparedStatement pst =cnx.prepareStatement(requete4);
                      //  pst.setInt(5, id);
                        pst.setString(1, nom);
                       
                  
                       
                        
            pst.executeUpdate();
            System.out.println("categorie est modifiee");
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
        
         public void delete(Categorie e) {
     
         String requete = "DELETE FROM categorie WHERE id =" + e.getId();
        
           try {
            ste = cnx.createStatement();
            ste.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCategorie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    

    @Override
    public List<Categorie> Afficher() {
        
         
         List<Categorie> events = new ArrayList<>();
        try {
            String req ="select * from categorie";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
               Categorie p = new Categorie();
               p.setId(rs.getInt(1));
               p.setNom(rs.getString(2));
              
           
               events.add(p);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());        }
            
        return events;
        
        
        
    }
    
     public ObservableList<Categorie>affichercategorie(){
       ObservableList<Categorie> myList = FXCollections.observableArrayList();
        try {
            
            String requete3 = "SELECT * FROM categorie";
            Statement st = cnx.createStatement();
           ResultSet rs = st.executeQuery(requete3);
           while(rs.next()){
               Categorie P = new Categorie();
                P.setId(rs.getInt(1));
               P.setNom(rs.getString("nom"));
              
               
               
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

   public Categorie getCategorie(int id) {

   String requete = "select * FROM categorie WHERE id = '" + id + "'";
        Categorie cr = new Categorie();
        
           try {
            ste = cnx.createStatement();
                       rs= ste.executeQuery(requete);
            while (rs.next()) { 
      
                
                 cr.setId(id);
                 cr.setNom(rs.getString("nom"));
               
                 
                 
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceTicket.class.getName()).log(Level.SEVERE, null, ex);
        }
            return cr;
   
   
   }
        
}
