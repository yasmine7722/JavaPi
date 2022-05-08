/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.ProgNutri;
import Service.Mailling;
import Service.ServiceNutri;
import java.io.IOException;
import static java.lang.Math.E;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author toshiba
 */
public class AjoutNutriController implements Initializable {

    @FXML
    private TextField i1;
    @FXML
    private Button b1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AddNutri(ActionEvent event) {
        
        
        
         if(i1.getText().equals("")) {
            System.out.println("nom requi");
        }
         
         
         
        ProgNutri p = new ProgNutri(i1.getText()) ;
        
         Mailling M = new Mailling() ; 
        M.sendEmail("yasmine.bouakroucha@esprit.tn",p.getNom(),"programme nutrition ajouté avec succes");
        
        
        ServiceNutri ps=new ServiceNutri();
        ps.Ajouter(p);
        
        
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/DetailNutri.fxml"));
        
        try {
        
        
        Parent root = loader.load();
        DetailNutriController controller =loader.getController();
        controller.setL1(p.getNom());
        i1.getScene().setRoot(root);
        
   
        }catch (IOException ex){
                  System.out.println("aloooo");
                    }
        
        
        
        
    }
    
}
