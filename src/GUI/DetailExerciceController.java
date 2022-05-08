/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author toshiba
 */
public class DetailExerciceController implements Initializable {

    @FXML
    private Label l1;
    @FXML
    private Label l2;
    @FXML
    private Label l3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
  
    public void setL1(String l){
    
    this.l1.setText(l);
    
    }
    
    public void setL2(String l){
    
    this.l2.setText(l);
    
    }
    
    public void setL3(int l){
    
    this.l3.setText(String.valueOf(l));
    
    }

    @FXML
    private void retour(ActionEvent event) {
        
         try {

         Parent root = FXMLLoader.load(getClass().getResource("/GUI/AjoutEx.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        
        
    }
    
}   
