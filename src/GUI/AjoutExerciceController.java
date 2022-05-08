/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Exercice;
import Service.Mailling;
import Service.ServiceExercice;
import java.io.IOException;
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
public class AjoutExerciceController implements Initializable {

    @FXML
    private TextField i1;
    @FXML
    private TextField i2;
    @FXML
    private TextField i3;
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
    private void AddEx(ActionEvent event) {
        
        
        String nom = i1.getText();
        String description = i2.getText();
       int repetition =Integer.parseInt(i3.getText()) ;
        
       
       Exercice E = new Exercice(repetition, nom , description);
       
       
        Mailling M = new Mailling() ; 
        M.sendEmail("ahmed.bouakroucha@esprit.tn",E.getNom(),"Exercice ajouté avec succes");
       
        ServiceExercice ps=new ServiceExercice();
        ps.Ajouter(E);
        
       
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/DetailExercice.fxml"));
        
        try {
        
        
        Parent root = loader.load();
        DetailExerciceController controller =loader.getController();
        controller.setL1(E.getNom());
        controller.setL2(E.getDescription());
        controller.setL3(repetition);
        i1.getScene().setRoot(root);
        
   
        }catch (IOException ex){
                  System.out.println("aloooo");
                    }
        
        
        
        
        
    }
    
}
