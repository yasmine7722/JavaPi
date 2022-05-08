/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Exercice;
import Entity.ProgNutri;
import Entity.Repas;
import Service.ServiceExercice;
import Service.ServiceNutri;
import Service.ServiceRepas;
import java.io.IOException;
import java.net.URL;
import java.util.List;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author toshiba
 */
public class AjoutRepasController implements Initializable {

    @FXML
    private Button b1;
    @FXML
    private TextField i1;
    @FXML
    private TextField i2;
    @FXML
    private TextField i3;
    @FXML
    private TextField i4;
    @FXML
    private TextField i5;
    @FXML
    private TextField i6;
    @FXML
    private TextField i7;
    @FXML
    private TextField i8;
    @FXML
    private ComboBox<ProgNutri> ComListNut;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         ServiceNutri cs = new ServiceNutri();
         List<ProgNutri> listcat = cs.Afficher()   ;
          
        ObservableList<ProgNutri> List = FXCollections.observableArrayList(listcat);
            ComListNut.setItems(List);
        
        
        
        
    }    
    
    void setCombo(ProgNutri p) {
       
       this.ComListNut.setValue(p);
    }
    

    @FXML
    private void AddR(ActionEvent event) {
        
        
        
        String nom = i1.getText();
        String description = i2.getText();
        String proteine = i3.getText();
        String glucides= i4.getText();
        String legumes = i5.getText();
       int nbCal =Integer.parseInt(i6.getText()) ;
       int nbleg =Integer.parseInt(i7.getText()) ;
       int nbgluc =Integer.parseInt(i8.getText()) ;
      int idN = ComListNut.getValue().getId();
       
       
         
       Repas r = new Repas(nom , description,proteine,glucides,legumes,nbCal,nbleg,nbgluc,idN);
        ServiceRepas ps=new ServiceRepas();
        ps.Ajouter(r);
        

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/DetailRepas.fxml"));
        
        try {
        
        
        Parent root = loader.load();
        DetailRepasController controller =loader.getController();
        controller.setL1(r.getNom());
        controller.setL2(r.getDescription());
        controller.setL3(proteine);
        controller.setL4(glucides);
        controller.setL5(legumes);
       controller.setL6(nbCal);
       controller.setL7(nbleg);
       controller.setL8(nbgluc);
         controller.setL8(nbgluc);
        i1.getScene().setRoot(root);
        
   
        }catch (IOException ex){
                  System.out.println("aloooo");
                    }
        
        
        
        
        
        
        
        
    }

    @FXML
    private void rr(ActionEvent event) {
        
        
        
         try {

         Parent root = FXMLLoader.load(getClass().getResource("/GUI/Dash.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        
        
    }
    
}
