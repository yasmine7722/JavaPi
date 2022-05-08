/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Exercice;
import Entity.Repas;
import Service.ServiceExercice;
import Service.ServiceRepas;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author toshiba
 */
public class DashEController implements Initializable {

    @FXML
    private Label ex;
    private Parent fxml;
    private AnchorPane root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjoutE(ActionEvent event) {
        
         try {

         Parent root = FXMLLoader.load(getClass().getResource("/GUI/AjoutEx.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        
  
    }

    @FXML
     private void pdf(ActionEvent event) throws SQLException {
        
         ServiceExercice as = new ServiceExercice();
       // ObservableList<ProgNutri> list = (ObservableList<ProgNutri>) as.Afficher();
       // ObservableList<ProgNutri> list = as.Afficher();
        ObservableList<Exercice> list = as.afficherExercice();
        
        try{
            OutputStream file = new FileOutputStream(new File("C:\\Users\\toshiba\\Desktop\\ProgPdf\\exercice.pdf"));
            Document document = new Document();
            PdfWriter.getInstance(document, file);
            document.open();
            
            Font font = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
            Paragraph pdfTitle = new Paragraph("Liste des exercices", font);
            pdfTitle.setAlignment(Element.ALIGN_CENTER);
            
            document.add(pdfTitle);
            document.add(new Chunk("\n"));
            PdfPTable table = new PdfPTable(2);
            table.setHeaderRows(1);
            
            table.addCell("Nom Exercice");
             table.addCell("Description");
             
              
         System.out.println("Exercices téléchargé en PDF avec succès");
            list.forEach((_item) -> {
           
                table.addCell(_item.getNom());
                 table.addCell(_item.getDescription());
              
                
            });
            
            document.add(table);
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
              alert.setTitle("Success");
            alert.setContentText("Success!");
            document.close();

            file.close();


        } catch (Exception ex) {
           Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Cannot export data!");
            alert.show();
        }
    
        
    }

    @FXML
    private void show(MouseEvent event) {
        
    
        
    }

    @FXML
    private void sta(ActionEvent event) {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/GUI/StatE.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
    
}
