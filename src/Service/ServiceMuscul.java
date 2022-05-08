/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.ProgMuscul;
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

/**
 *
 * @author toshiba
 */
public class ServiceMuscul implements InterfaceCrud<ProgMuscul> {
    
        Connection cnx;
        private Statement ste;

         public ServiceMuscul() {
        cnx=DataSource.getInstance().getConn();
    }
        

    @Override
    public void Ajouter(ProgMuscul e) {
         try {
            String req = "insert into prog_muscul(nom)"
                    +"values('"+e.getNom()+"')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Programme ajouté avec succès");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        
        }
    }

    @Override
    public void Modifier(ProgMuscul e) {
        
       
        
        
    }

    
    
    public void delete(int id) {
     
         String requete = "DELETE FROM prog_muscul WHERE id ="+id;
        
           try {
            ste = cnx.createStatement();
            ste.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceMuscul.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
   
    
    
    
    @Override
    public void Supprimer(int ID) {
        
    
        
        
        
    }
    
    
     public void update(int id) {
            
         
        try {
            Scanner sc=new Scanner(System.in); 
        System.out.print("Nom = ");  
        String nom= sc.nextLine();  
        String req="UPDATE prog_muscul SET nom=? WHERE id=?";
            
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
    public List<ProgMuscul> Afficher() {
        
         List<ProgMuscul> programmes = new ArrayList<>();
        try {
            String req ="select * from prog_muscul";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
               ProgMuscul p = new ProgMuscul();
               p.setId(rs.getInt(1));
               p.setNom(rs.getString(3));
               programmes.add(p);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());        }
            
        return programmes;
    }
   
    
}
