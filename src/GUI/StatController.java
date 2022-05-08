/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Util.DataSource;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author toshiba
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
           String req = "SELECT nb_caloris,nom FROM repas";
                Statement st = cnx.createStatement();
             ResultSet rs = cnx.createStatement().executeQuery(req);

            while (rs.next()) {
               data.add(new PieChart.Data(rs.getString(2),rs.getInt(1)));
                
            }
            statt.setTitle("Nombre De calorie par programme");
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
    private void re(ActionEvent event) {
        
         try{
            Parent root = FXMLLoader.load(getClass().getResource("/GUI/Dash.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        
        
    }
    
    
    
}
