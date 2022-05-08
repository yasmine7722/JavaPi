/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Exercice;
import Entity.ProgMuscul;
import Service.Mailling;
import Service.ServiceExercice;
import Service.ServiceMuscul;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author toshiba
 */
public class AjoutExController implements Initializable {

    @FXML
    private TextField i1;
    @FXML
    private TextField i2;
    @FXML
    private TextField i3;
    @FXML
    private ComboBox<ProgMuscul> ExList;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
ServiceMuscul cs = new ServiceMuscul();
         List<ProgMuscul> listcat = cs.Afficher()   ;
          
        ObservableList<ProgMuscul> List = FXCollections.observableArrayList(listcat);
            ExList.setItems(List);
        
        
        
    }    

    
    
void setCombo(ProgMuscul p) {
       
       this.ExList.setValue(p);
    }

    
    
    @FXML
    private void AddEx(ActionEvent event) {
        
        
        String nom = i1.getText();
        String description = i2.getText();
       int repetition =Integer.parseInt(i3.getText()) ;
       int idN = ExList.getValue().getId();
          
       Exercice E = new Exercice(repetition, nom , description,idN);
       
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

    @FXML
    private void retour(ActionEvent event) {
        
         try {

         Parent root = FXMLLoader.load(getClass().getResource("/GUI/DashE.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        
        
        
    }
    
}
