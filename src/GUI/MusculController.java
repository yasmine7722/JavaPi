/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entity.Event;
import Entity.ProgMuscul;
import Service.ServiceEvent;
import Service.ServiceMuscul;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
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

    /**
     * Initializes the controller class.
     */
    public class MusculController   implements Initializable {
    private Label label;
    @FXML
    private TextField nom_m;
   
    @FXML
    private DatePicker tfdate_m;
    @FXML
    private Button Btn_modifier_m;
    @FXML
    private Button Btn_ajouter_m;
    @FXML
    private Button Btn_supprimer_m;
    @FXML
    private TableView<ProgMuscul> tab_m;
    @FXML
    private TableColumn<ProgMuscul, String> nom;
  
     int index=-1;
    @FXML
    private TableColumn<ProgMuscul, Date> date;
    public ObservableList<ProgMuscul> data=FXCollections.observableArrayList();
    
    
    
  
   
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        show();
        
       
        // TODO
    }    
     private boolean nom_evalide(){
        Pattern p = Pattern.compile("[a-zA-Z]+");
        Matcher m = p.matcher(nom_m.getText());
        if(m.find() && m.group().equals(nom_m.getText())){
            return true;
        }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Type validé !");
                alert.setHeaderText(null);
                alert.setContentText("Veuillez entrer un nom validé !");
                alert.showAndWait();
           
            return false;            
        }
     }
  
          @FXML
      void getSelected(MouseEvent event){
     index=tab_m.getSelectionModel().getSelectedIndex();
     if(index<=-1){
         return ;
     }
     nom_m.setText(nom.getCellData(index).toString());
     
     
     
     
     tfdate_m.setValue(date.getCellData(index).toLocalDate());

      

     }

      
     
     
    @FXML
    private void modif_m(ActionEvent event) {
         
        String nom_ev=nom_m.getText();
       
        
        
        
       
        Date date_fin_ev =  Date.valueOf(tfdate_m.getValue());
        ProgMuscul e=new ProgMuscul();
      e.setNom(nom_ev);
      
     
      
      
      e.setDate(date_fin_ev);
    
        ServiceMuscul ev=new ServiceMuscul();
        e=tab_m.getSelectionModel().getSelectedItem();
             System.out.println("id evenements courant= "+e.getId());
        ev.updatepm(e,nom_ev,date_fin_ev);
       

   show();

          }

    

    
    @FXML
    private void ajout_m(ActionEvent event) {
         
        String nom_ev=nom_m.getText();
 
        
        Date date_fin_ev =  Date.valueOf(tfdate_m.getValue());
        ProgMuscul e=new ProgMuscul();
        e.setNom(nom_ev);

      e.setDate(date_fin_ev);
        ServiceMuscul ev=new ServiceMuscul();

        ev.Ajouter(e);
       
           show();

      
         }

   

    @FXML
    private void supprimer_m(ActionEvent event) {
         ServiceMuscul eve = new ServiceMuscul();
              ProgMuscul e= new ProgMuscul();   
              e= tab_m.getSelectionModel().getSelectedItem();
              eve.deletepm(e);
              
          
             show();

             
    }
//    
//    
//    
//    
//
//    
//    
//    
//    
//    
//    
       public void show(){
           ServiceMuscul ev = new ServiceMuscul();
            ObservableList<ProgMuscul> list = ev.afficherpm();
            
         
                nom.setCellValueFactory(new PropertyValueFactory<ProgMuscul,String>("nom")); 
             
                  
              
               date.setCellValueFactory(new PropertyValueFactory<ProgMuscul,Date>("date"));
                 tab_m.setItems(list);
            
             
                
    }
 
         
     

  
    
       }
    
    
    
    

    

