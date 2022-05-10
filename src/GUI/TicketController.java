/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entity.Categorie;
import Service.ServiceBlog;
import Service.ServiceCategorie;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;


/**
 * FXML Controller class
 *
 * @author Dell
 */
public class TicketController implements Initializable {

    @FXML
    private TableColumn<Categorie, String> nom;
    @FXML
    private TextField nom_t;
    @FXML
    
    private TableView<Categorie> tab;
    int index=-1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        show();
    }    

    @FXML
    private void ajout(ActionEvent event) {
        
        
         String nom_ev=nom_t.getText();
        
        
       
        
        
       
        Categorie e=new Categorie();
      e.setNom(nom_ev);
     
    
        ServiceCategorie ev=new ServiceCategorie();
       
        
        
        
        
        
        
        
        
        ev.Ajouter(e);
        show();
        
    }
    
     public void show(){
           ServiceCategorie ev = new ServiceCategorie();
            ObservableList<Categorie> list = ev.affichercategorie();
            
         
                nom.setCellValueFactory(new PropertyValueFactory<Categorie,String>("nom")); 
             
                 
              
             
                 tab.setItems(list);
            
             
                
    }
    
       @FXML
      void getSelected(MouseEvent event){
     index=tab.getSelectionModel().getSelectedIndex();
     if(index<=-1){
         return ;
     }
     nom_t.setText(nom.getCellData(index).toString());
     
     
     
     
     

      

     }

    @FXML
    private void modif(ActionEvent event) {
        
         String nom_ev=nom_t.getText();

        Categorie t=new Categorie();
      t.setNom(nom_ev);
   ServiceCategorie ev=new ServiceCategorie();
        t=tab.getSelectionModel().getSelectedItem();
             System.out.println("id categorie courant= "+t.getId());
        
       

   show();
        
        
        
    }

    @FXML
    private void dell(ActionEvent event) {
         ServiceCategorie eve = new ServiceCategorie();
              Categorie e= new Categorie();   
              e= tab.getSelectionModel().getSelectedItem();
              eve.delete(e);
          
             show();
    }

   
    
}
