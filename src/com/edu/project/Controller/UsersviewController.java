/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.project.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author toshiba
 */
public class UsersviewController implements Initializable {

    @FXML
    private TextField searchbox;
    @FXML
    private VBox chosenFruitCard;
    @FXML
    private Label username;
    @FXML
    private Label userrole;
    @FXML
    private ImageView fruitImg;
    @FXML
    private Label usernumtel;
    @FXML
    private Label userage;
    @FXML
    private Label useremail;
    @FXML
    private Label usernom;
    @FXML
    private Label userprenom;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    @FXML
    private AnchorPane anchorforedit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void searchmewell(KeyEvent event) {
    }

    @FXML
    private void modifieruser(ActionEvent event) {
    }

    @FXML
    private void supprimeruser(ActionEvent event) {
    }

    @FXML
    private void backtomain(ActionEvent event) {
    }
    
}
