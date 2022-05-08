/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author toshiba
 */
public class DetailRepasController implements Initializable {

    @FXML
    private Label l1;
    @FXML
    private Label l2;
    @FXML
    private Label l3;
    @FXML
    private Label l4;
    @FXML
    private Label l5;
    @FXML
    private Label l6;
    @FXML
    private Label l7;
    @FXML
    private Label l8;
    private Label l9;

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
    
    
     public void setL3(String l){
    
    this.l3.setText(l);
    
    }
     
      public void setL4(String l){
    
    this.l4.setText(l);
    
    }
      
      
       public void setL5(String l){
    
    this.l5.setText(l);
    
    }
    
    public void setL6(int l){
    
    this.l6.setText(String.valueOf(l));
    
    
    }
    
    public void setL7(int l){
    
    this.l7.setText(String.valueOf(l));
    
    
    }
    
    
    public void setL8(int l){
    
    this.l8.setText(String.valueOf(l));
    
    
    }
    
    
}
