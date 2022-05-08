/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.ProgNutri;
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
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author toshiba
 */
public class ServiceNutri implements InterfaceCrud<ProgNutri> {
            Connection cnx;
            private ResultSet rs;
               private Statement ste;
    private PreparedStatement pst ;
 
            

    public ServiceNutri() {
        cnx=DataSource.getInstance().getConn();
    }
            
            

     public ProgNutri  getProgNutri(int id) {
     
         String requete = "select * FROM prog_nutri WHERE id = '" + id + "'";
        ProgNutri cr = new ProgNutri();
        
           try {
            ste = cnx.createStatement();
                       rs= ste.executeQuery(requete);
            while (rs.next()) { 
      
                
                 cr.setId(id);
                 cr.setNom(rs.getString("nom"));
               
                 
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceNutri.class.getName()).log(Level.SEVERE, null, ex);
        }
            return cr;
    }

    @Override
    public void Ajouter(ProgNutri e) {
        
         try {
            String req = "insert into prog_nutri(nom)"
                    +"values('"+e.getNom()+"')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Programme ajouté avec succès");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        
        }
        
    }

    
public ObservableList<ProgNutri>afficherProg(){
       ObservableList<ProgNutri> myList = FXCollections.observableArrayList();
        try {
            
            String requete3 = "SELECT nom FROM prog_nutri";
            Statement st = cnx.createStatement();
           ResultSet rs = st.executeQuery(requete3);
           while(rs.next()){
                         
       
               ProgNutri P = new ProgNutri();
               
               P.setNom(rs.getString("nom"));
              
        
               
               myList.add(P);
           }
           
           
           
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
        
    }
    
    
    
    
    
    
    public void update(int id) {
            
         
        try {
            Scanner sc=new Scanner(System.in); 
        System.out.print("Nom = ");  
        String nom= sc.nextLine();  
        String req="UPDATE prog_nutri SET nom=? WHERE id=?";
            
           PreparedStatement ps= cnx.prepareStatement(req);
            ps.setString(1, nom);
             ps.setInt(2, id=id);
            
           
           
            
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Programme Modifié avec succès");
            }       } catch (SQLException ex) {
            Logger.getLogger(ServiceNutri.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }
    
    
    
    
    
    @Override
    public void Modifier(ProgNutri e) {
        
         try {
            String req ="UPDATE prog_nutri SET nom=? WHERE id=?";
            PreparedStatement ps= cnx.prepareStatement(req);
            ps.setString(1, e.getNom() );
          ps.executeUpdate();
                        System.out.println("Programme Modifié avec succès");

        } catch (SQLException ex) {
            Logger.getLogger(ServiceNutri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void Supprimer(int ID) {
        
         
        try
    {
      //étape 1: charger la classe driver
      Class.forName("com.mysql.jdbc.Driver");
      //étape 2: créer l'objet de connexion
      Connection conn = DriverManager.getConnection(
      "jdbc:mysql://localhost:3306/pidev?useSSL=false", "root", "");
      //étape 3: créer l'objet statement 
      Statement stmt = conn.createStatement();
      //étape 4: exécuter la requête
      System.out.println("Suppression...");
      String sql = "DELETE FROM prog_nutri WHERE id = id";
                  PreparedStatement statement = conn.prepareStatement(sql);

      
      stmt.executeUpdate(sql);
      System.out.println("L'enregistrement avec l'id =  a été supprimer avec succès...");
      //étape 5: fermez l'objet de connexion
      conn.close();
    }
    catch(Exception e){ 
      System.out.println(e);
    }
        
    }

    @Override
    public List<ProgNutri> Afficher() {
        
         List<ProgNutri> programmes = new ArrayList<>();
        try {
            String req ="select * from prog_nutri";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
               ProgNutri p = new ProgNutri();
               p.setId(rs.getInt(1));
               p.setNom(rs.getString(3));
               programmes.add(p);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());        }
            
        return programmes;
        
    }
    
}
