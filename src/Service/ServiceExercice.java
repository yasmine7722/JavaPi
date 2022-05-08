/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Exercice;
import Entity.ProgNutri;
import Util.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author toshiba
 */
public class ServiceExercice implements InterfaceCrud<Exercice> {

     Connection cnx;
     private Statement ste;

         public ServiceExercice() {
        cnx=DataSource.getInstance().getConn();
    }
       
    
    @Override
    public void Ajouter(Exercice e) {
        try {
            String req = "insert into exercice(repetition,nom,description,prog_mus_id)"
                    +"values('"+e.getRepetition()+"','"+e.getNom()+"','"+e.getDescription()+"','"+e.getProg_mus_id()+"')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Exercice ajouté avec succès");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        
        }
    }

    
    public ObservableList<Exercice>afficherExercice(){
       ObservableList<Exercice> myList = FXCollections.observableArrayList();
        try {
            
            String requete3 = "SELECT nom,description FROM exercice";
            Statement st = cnx.createStatement();
           ResultSet rs = st.executeQuery(requete3);
           while(rs.next()){
                         
       
               Exercice P = new Exercice();
               
               P.setNom(rs.getString("nom"));
               P.setDescription(rs.getString("description"));
        
               
               myList.add(P);
           }
           
           
           
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
        
    }
     
     public void update(int id) {
            
         
        try {h
            Scanner sc=new Scanner(System.in); 
        System.out.print("Nom = ");  
        String nom= sc.nextLine(); 
        System.out.print("description = ");  
        String description= sc.nextLine();
        System.out.print("repetition = ");  
        int repetition= sc.nextInt();
       
        String req="UPDATE exercice SET nom=?,description=?,repetition=? WHERE id=?";
            
           PreparedStatement ps= cnx.prepareStatement(req);
            ps.setString(1, nom);
            ps.setString(2, description);
             ps.setInt(3, repetition);
             ps.setInt(4, id=id);
            
           
           
            
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("exercice Modifié avec succès");
            }       } catch (SQLException ex) {
            Logger.getLogger(ServiceNutri.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }
    
    
      
    public void delete(int id) {
     
         String requete = "DELETE FROM exercice WHERE id ="+id;
        
           try {
            ste = cnx.createStatement();
            ste.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceExercice.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     
     
     
    @Override
    public void Modifier(Exercice e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Supprimer(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Exercice> Afficher() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}
