/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Article;
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
public class ServiceBlog implements InterfaceCrud<Article> {
Connection cnx;

    public ServiceBlog() {
        
                cnx=DataSource.getInstance().getConn();

    }


    @Override
    public void Ajouter(Article e) {
        
          try {
            String req = "insert into article(theme)"
                    +"values('"+e.getTheme()+"')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Blog ajouté avec succès");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        
        }
    }

    @Override
    public void Modifier(Article e) {
        
          try {
            String req ="UPDATE article SET theme=? WHERE id=?";
            PreparedStatement ps= cnx.prepareStatement(req);
            ps.setString(1, e.getTheme() );
          ps.executeUpdate();
                        System.out.println("Blog Modifié avec succès");

        } catch (SQLException ex) {
            Logger.getLogger(ServiceBlog.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @Override
    public void Supprimer(int ID) {
    }

    @Override
    public List<Article> Afficher() {
        
         
         List<Article> articles = new ArrayList<>();
        try {
            String req ="select * from event";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
               Article p = new Article();
               p.setId(rs.getInt(1));
               p.setTheme(rs.getString(3));
               articles.add(p);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());        }
            
        return articles;
        
        
        
    }
    
}
