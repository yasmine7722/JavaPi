/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.ProgNutri;
import Entity.Repas;
import Service.ServiceNutri;
import Service.ServiceRepas;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import javafx.scene.control.Alert;
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
import java.sql.SQLException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author toshiba
 */
public class DashController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void pdf(ActionEvent event) throws SQLException {
        
         ServiceRepas as = new ServiceRepas();
       // ObservableList<ProgNutri> list = (ObservableList<ProgNutri>) as.Afficher();
       // ObservableList<ProgNutri> list = as.Afficher();
        ObservableList<Repas> list = as.afficherRepas();
        
        try{
            OutputStream file = new FileOutputStream(new File("C:\\Users\\toshiba\\Desktop\\ProgPdf\\repas.pdf"));
            Document document = new Document();
            PdfWriter.getInstance(document, file);
            document.open();
            
            Font font = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
            Paragraph pdfTitle = new Paragraph("Liste des repas", font);
            pdfTitle.setAlignment(Element.ALIGN_CENTER);
            
            document.add(pdfTitle);
            document.add(new Chunk("\n"));
            PdfPTable table = new PdfPTable(5);
            table.setHeaderRows(1);
            
            table.addCell("Nom Repas");
             table.addCell("Description");
              table.addCell("Protéine");
               table.addCell("Glucides");
                table.addCell("Legumes");
         System.out.println("Repas téléchargé en PDF avec succès");
            list.forEach((_item) -> {
           
                table.addCell(_item.getNom());
                 table.addCell(_item.getDescription());
                  table.addCell(_item.getIngrediant1());
                   table.addCell(_item.getGlucides());
                    table.addCell(_item.getLegumes());
                
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
    private void st(ActionEvent event) {
        
         try{
            Parent root = FXMLLoader.load(getClass().getResource("/GUI/Stat.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        
    }
    
}
