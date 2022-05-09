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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author toshiba
 */
public class ServiceUtilisateur implements InterfaceCrud<Utilisateur> {
    
    Connection cnx;

    public ServiceUtilisateur() {
                cnx=DataSource.getInstance().getConn();

    }
    

    @Override
    public void Ajouter(Utilisateur e) {
        
         try {
            String req = "insert into utilisateur(email,password,username)"
                    +"values('"+e.getEmail()+"','"+e.getPassword()+"',"+"','"+e.getUsername()+"')";
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

    @Override
    public void Supprimer(int ID) {
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
    
        
 }
   
