/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Exercice;
import Entity.ProgNutri;
import Entity.Repas;
import Util.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author toshiba
 */
public class ServiceRepas {
    
    
     Connection cnx;
     private Statement ste;

         public ServiceRepas() {
        cnx=DataSource.getInstance().getConn();
    }
       
         
         
    
    public void Ajouter(Repas e) {
        try {
            String req = "insert into repas(nom,description,ingrediant1,glucides,legumes,nb_caloris,quant_legu,quant_gluc,prog_nutr_id)"
                    +"values('"+e.getNom()+"','"+e.getDescription()+"','"+e.getIngrediant1()+"','"+e.getGlucides()+"','"+e.getLegumes()+"','"+e.getNb_caloris()+"','"+e.getQuant_legu()+"','"+e.getQuant_gluc()+"','"+e.getProg_nutr_id()+"')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Repas ajouté avec succès");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        
        }
    }

    
    
    
    public ObservableList<Repas>afficherRepas(){
       ObservableList<Repas> myList = FXCollections.observableArrayList();
        try {
            
            String requete3 = "SELECT nom,description,ingrediant1,glucides,legumes FROM repas";
            Statement st = cnx.createStatement();
           ResultSet rs = st.executeQuery(requete3);
           while(rs.next()){
                         
       
               Repas P = new Repas();
               
               P.setNom(rs.getString("nom"));
               P.setDescription(rs.getString("description"));
               P.setIngrediant1(rs.getString("ingrediant1"));
               P.setGlucides(rs.getString("glucides"));
               P.setLegumes(rs.getString("legumes"));

        
               
               myList.add(P);
                   
           }
           
           
           
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
        
    }
    
    
    
    
}
