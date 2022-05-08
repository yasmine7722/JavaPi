/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Event;
import Util.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
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
public class ServiceEvent implements InterfaceCrud<Event> {
Connection cnx;

    public ServiceEvent() {
        
                cnx=DataSource.getInstance().getConn();

    }


    @Override
    public void Ajouter(Event e) {
        
          try {
            String req = "insert into event(nom)"
                    +"values('"+e.getNom()+"')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Event ajouté avec succès");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        
        }
    }

    @Override
    public void Modifier(Event e) {
        
          try {
            String req ="UPDATE event SET nom=? WHERE id=?";
            PreparedStatement ps= cnx.prepareStatement(req);
            ps.setString(1, e.getNom() );
          ps.executeUpdate();
                        System.out.println("Event Modifié avec succès");

        } catch (SQLException ex) {
            Logger.getLogger(ServiceEvent.class.getName()).log(Level.SEVERE, null, ex);
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
      String sql = "DELETE FROM event WHERE id = id";
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
    public List<Event> Afficher() {
        
         
         List<Event> events = new ArrayList<>();
        try {
            String req ="select * from event";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
               Event p = new Event();
               p.setId(rs.getInt(1));
               p.setNom(rs.getString(3));
               events.add(p);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());        }
            
        return events;
        
        
        
    }
        
}
