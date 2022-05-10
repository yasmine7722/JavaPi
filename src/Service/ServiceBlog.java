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
import Service.ServiceCategorie;

/**
 *
 * @author toshiba
 */
public class ServiceBlog  {
Connection cnx;
 private Statement ste;

    public ServiceBlog() {
        
                cnx=DataSource.getInstance().getConn();

    }


 //Ajouter
    public void Ajouter(Article e) {
//          LocalDateTime now = LocalDateTime.now();
//                 e.setDate(now );

          String req = "insert into article(theme,date,categorie_id,description)"
                    +"values('"+e.getTheme()+"','"+e.getDate()+"','"+e.getCategorie_id()+"','"+e.getDescription()+"')";
             try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Artricle ajouté avec succès");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        
        }
    }

  
 //Supprimer
    
    
       public void delete(Article e) {
     
         String requete = "DELETE FROM article WHERE id =" + e.getId();
        
           try {
            ste = cnx.createStatement();
            ste.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
       

 

//Afficher    
    
    public ObservableList<Article>afficherArticle(){
       ObservableList<Article> myList = FXCollections.observableArrayList();
        try {
            
            String requete3 = "SELECT * FROM article";
            Statement st = cnx.createStatement();
           ResultSet rs = st.executeQuery(requete3);
           while(rs.next()){
             ServiceCategorie ts = new ServiceCategorie();
              Categorie categorie= new Categorie(); 


 categorie =  ts.getCategorie(rs.getInt("categorie_id"));              
               
               
               Article P = new Article();
                P.setId(rs.getInt(1));
               P.setDescription(rs.getString("description"));
              
                P.setTheme(rs.getString("theme"));
               P.setDate(rs.getDate("date"));
               P.setCategorie_id(rs.getInt("categorie_id"));
               
               myList.add(P);
           }
           
           
           
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
        
    }
    
    //Modifier
    
    
     public void updateev(Article e, String theme,Date date ,String description,int categorie_id){
        try {
            String requete4 =" UPDATE article SET " + " theme = ?, date = ? , description=?, categorie_id=? WHERE id = " + e.getId() ;
            PreparedStatement pst =cnx.prepareStatement(requete4);
                      //  pst.setInt(5, id);
                        pst.setString(1, theme);
                        pst.setString(3, description);
                         pst.setDate(2, date);
                         pst.setInt(4, categorie_id);
                     
                     
                       
                        
            pst.executeUpdate();
            System.out.println("votre article est modifiee");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    
    
    
        
}
