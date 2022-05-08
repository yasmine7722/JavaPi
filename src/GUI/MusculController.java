/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author toshiba
 */
public class MusculController implements Initializable {

    @FXML
    private TextField nom_m;
    @FXML
    private TableView<?> tab_m;
    @FXML
    private TableColumn<?, ?> nom;
    @FXML
    private TableColumn<?, ?> date;
    @FXML
    private Button Btn_ajouter_m;
    @FXML
    private Button Btn_modifier_m;
    @FXML
    private Button Btn_supprimer_m;
    @FXML
    private DatePicker tfdate_m;
    @FXML
    private ComboBox<?> exe;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void getSelected(MouseEvent event) {
    }

    @FXML
    private void ajout_m(ActionEvent event) {
    }

    @FXML
    private void modif_m(ActionEvent event) {
    }

    @FXML
    private void supprimer_m(ActionEvent event) {
    }
    
}
