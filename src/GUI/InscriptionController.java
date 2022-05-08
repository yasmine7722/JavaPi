/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Utilisateur;
import Service.Mailling;
import Service.ServiceUtilisateur;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author toshiba
 */
public class InscriptionController implements Initializable {

    @FXML
    private TextField i1;
    @FXML
    private TextField i2;
    @FXML
    private TextField i3;
    private TextField i4;
    @FXML
    private Button b1;
    @FXML
    private ChoiceBox<String> comR;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> availableChoices = FXCollections.observableArrayList("COACH","SPORTIF");
      comR.getItems().addAll(availableChoices);
    }    

    @FXML
    private void AddUser(ActionEvent event) {
        
        
           if(i1.getText().equals("")) {
            System.out.println("email requi");
        }
        Utilisateur p = new Utilisateur(i1.getText(),comR.getSelectionModel().getSelectedItem(),i3.getText(),i2.getText()) ;
        Mailling M = new Mailling() ; 
        M.sendEmail("mohamedselim.khanfir@esprit.tn",p.getUsername(),"Inscription avec succes");
         ServiceUtilisateur ps=new ServiceUtilisateur();
        ps.Ajouter(p);
        
         
      
        
          
       try {

         Parent root = FXMLLoader.load(getClass().getResource("../GUI/Acceuil.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        
        
        
    }
    
}
