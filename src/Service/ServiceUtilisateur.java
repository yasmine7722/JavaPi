/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Utilisateur;
import Util.DataSource;
import java.sql.Connection;
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

/**
 *
 * @author toshiba
 */
public class ServiceUtilisateur implements InterfaceCrud<Utilisateur> {
    
    Connection cnx;
  private Statement ste;
    public ServiceUtilisateur() {
                cnx=DataSource.getInstance().getConn();

    }
    

    @Override
    public void Ajouter(Utilisateur e) {
        
         try {
            String req = "insert into utilisateur(email,username,password,roles)"
                    +"values('"+e.getEmail()+"','"+e.getUsername()+"','"+e.getPassword()+"','"+e.getRoles()+"')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("utilisateur ajouté avec succès");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        
        }
        
    }

    @Override
    public void Modifier(Utilisateur e) {
        
        try {
            String req ="UPDATE personne SET email=?,password=?,username=? WHERE id=?";
            PreparedStatement ps= cnx.prepareStatement(req);
            
            ps.setString(1, e.getEmail());
            ps.setString(2, e.getPassword() );
            ps.setString(3, e.getUsername());
            ps.setInt(4, e.getId());

           ps.executeUpdate();
                        System.out.println("Personne Modifer avec succ");

        } catch (SQLException ex) {
            Logger.getLogger(ServiceUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
     
    public void update(int id) {
            
         
        try {
            Scanner sc=new Scanner(System.in); 
        System.out.print("Email = ");  
        String email= sc.nextLine(); 
        
         System.out.print("UserName = ");  
        String username= sc.nextLine(); 
        
         System.out.print("Password = ");  
        String password= sc.nextLine(); 
        
        
        
        String req="UPDATE prog_nutri SET email=? , username=? , password=? WHERE id=?";
            
           PreparedStatement ps= cnx.prepareStatement(req);
            ps.setString(1, email);
            ps.setString(2, username);
            ps.setString(3, password);
             ps.setInt(4, id=id);
            
           
           
            
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("utilisateur Modifié avec succès");
            }       } catch (SQLException ex) {
            Logger.getLogger(ServiceUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }
    
    public void delete(int id) {
     
         String requete = "DELETE FROM utilisateur WHERE id ="+id;
        
           try {
         ste = cnx.createStatement();
            ste.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    @Override
    public void Supprimer(int ID) {
        
    }

    
     public void updateev(Utilisateur e, String username, String email){
        try {
            String requete4 =" UPDATE utilisateur SET " + " username = ?, email = ? WHERE id = " + e.getId() ;
            PreparedStatement pst =cnx.prepareStatement(requete4);
                      //  pst.setInt(5, id);
                        pst.setString(1, username);
                        pst.setString(2, email);
                     
                       
                        
            pst.executeUpdate();
            System.out.println("utilisateur modifiee");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    
    public ObservableList<Utilisateur>afficherU(){
       ObservableList<Utilisateur> myList = FXCollections.observableArrayList();
        try {
            
            String requete3 = "SELECT * FROM utilisateur";
            Statement st = cnx.createStatement();
           ResultSet rs = st.executeQuery(requete3);
           while(rs.next()){
            
               
               Utilisateur P = new Utilisateur();
                P.setId(rs.getInt(1));
               P.setUsername(rs.getString("username"));
              
                P.setEmail(rs.getString("email"));
                
                P.setRoles(rs.getString("roles"));
              
               
               myList.add(P);
           }
           
           
           
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
        
    }
    
    
    
    @Override
    public List<Utilisateur> Afficher() {
        
          List<Utilisateur> utilisateurs = new ArrayList<>();
        try {
            String req ="select * from utilisateur";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
               Utilisateur p = new Utilisateur();
               p.setId(rs.getInt(1));
               p.setUsername(rs.getString(3));
               utilisateurs.add(p);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());        }
            
        return utilisateurs;
        
   
    }
    
    
    
        public List<Utilisateur> trierdesc(String trier)  throws SQLException {
        List<Utilisateur> users= new ArrayList<>();
        
        String req="SELECT * FROM `utilisateur` ORDER BY `utilisateur`.`"+trier+"` DESC";
               Statement st=cnx.createStatement();
        ResultSet RS=st.executeQuery(req);
        
        while (RS.next()){
            
           Utilisateur u = new Utilisateur();
            u.setId(RS.getInt(1));
            u.setUsername(RS.getString(2));
             u.setPassword(RS.getString(4))   ;
            u.setRoles(RS.getString(3));
            u.setEmail(RS.getString(6));
       users.add(u);
            
        }
        
        return users;
    }
            public List<Utilisateur> rechercher(String chercher)  throws SQLException {
        List<Utilisateur> users= new ArrayList<>();
        
       String req="SELECT * FROM utilisateur WHERE username like '%"+chercher+"%' or role like '%"+chercher+"%'";
               Statement st=cnx.createStatement();
        ResultSet RS=st.executeQuery(req);
        
        while (RS.next()){
            
           
           Utilisateur u = new Utilisateur();
            u.setId(RS.getInt(1));
            u.setUsername(RS.getString(2));
             u.setPassword(RS.getString(4))   ;
            u.setRoles(RS.getString(3));
            u.setEmail(RS.getString(6));
       users.add(u);
            
        }
        
        return users;
    }
    
        
 }
   
