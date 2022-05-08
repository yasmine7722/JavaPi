/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Util.DataSource;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;

/**
 * FXML Controller class
 *
 * @author toshiba
 */
public class StatEController implements Initializable {

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
        // TODO
    }    

    
    private void buildPieChartData() {
        try {
          DataSource ds = DataSource.getInstance();
          data = FXCollections.observableArrayList();
           cnx = ds.getConn();
           String req = "SELECT repetition,nom FROM exercice";
                Statement st = cnx.createStatement();
             ResultSet rs = cnx.createStatement().executeQuery(req);

            while (rs.next()) {
               data.add(new PieChart.Data(rs.getString(2),rs.getInt(1)));
                
            }
            statt.setTitle("Nombre de répétition des exercices de musculation");
            statt.setData(data);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
     }
    
    
    @FXML
    private void ViewChart(ActionEvent event) {
        
        
        
           
        buildPieChartData();
        
        
        
    }
    
}
