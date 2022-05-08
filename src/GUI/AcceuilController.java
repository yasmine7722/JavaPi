/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Utilisateur;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;



import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import Entity.Utilisateur;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import Service.ServiceUtilisateur;
import javafx.event.ActionEvent;
import javafx.scene.Node;

/**
 * FXML Controller class
 *
 * @author toshiba
 */
public class AcceuilController implements Initializable {

    private Label l1;
    @FXML
    private TableColumn<Utilisateur, String> un;
    @FXML
    private TableColumn<Utilisateur, String> em;
    @FXML
    private TableColumn<Utilisateur, String> rl;
    @FXML
    private TableView<Utilisateur> tb;
    @FXML
    private Button idu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        show();
        // TODO
    }   
    
    
     public void displayUsers(){
   
        ServiceUtilisateur su = new ServiceUtilisateur();
      List<Utilisateur> uList = su.Afficher();
      ObservableList<Utilisateur> ob = FXCollections.observableArrayList(uList);
       un.setCellValueFactory(new PropertyValueFactory<>("username"));
       em.setCellValueFactory(new PropertyValueFactory<>("email"));     
       rl.setCellValueFactory(new PropertyValueFactory<>("roles")); 
     
            }
     
     public void show(){
           ServiceUtilisateur ev = new ServiceUtilisateur();
            ObservableList<Utilisateur> list = ev.afficherU();
            
         
                un.setCellValueFactory(new PropertyValueFactory<Utilisateur,String>("username")); 
             
                  em.setCellValueFactory(new PropertyValueFactory<Utilisateur,String>("email"));
              
               rl.setCellValueFactory(new PropertyValueFactory<Utilisateur,String>("roles"));
               
               
                 tb.setItems(list);
            
            
                
    }

    @FXML
    private void stee(ActionEvent event) {
        
        
         try {

         Parent root = FXMLLoader.load(getClass().getResource("/GUI/StatU.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        
        
    }
    

    
  
    
    
}
