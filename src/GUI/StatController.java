/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Util.DataSource;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class StatController implements Initializable {

    @FXML
    private PieChart statt;
     private Statement st;
    private ResultSet rs;
    private Connection cnx;
    ObservableList<PieChart.Data>data=FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        }    
    
     private void buildPieChartData() {
        try {
          DataSource ds = DataSource.getInstance();
          data = FXCollections.observableArrayList();
           cnx = ds.getConn();
           String req = "SELECT prix,nom FROM ticket";
                Statement st = cnx.createStatement();
             ResultSet rs = cnx.createStatement().executeQuery(req);

            while (rs.next()) {
               data.add(new PieChart.Data(rs.getString(2),rs.getInt(1)));
                
            }
            statt.setTitle("Nombre De ticket");
            statt.setData(data);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }    

    @FXML
    private void ViewChart(ActionEvent event) {
          buildPieChartData();
    }

    @FXML
    private void toretour(ActionEvent event) {
            try{
            Parent root = FXMLLoader.load(getClass().getResource("/gui/ticket.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        
        
        
    }
    
}
