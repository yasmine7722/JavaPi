/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entity.Ticket;
import Service.ServiceEvent;
import Service.ServiceTicket;
import com.itextpdf.text.Chunk;
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
//mport com.itextpdf.text.Chunk;
import java.net.URL;
import java.sql.Date;
import java.util.List;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
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
 * @author Dell
 */
public class TicketController implements Initializable {

    @FXML
    private TableColumn<Ticket, String> nom;
    @FXML
    private TableColumn<Ticket, Integer> prix;
    @FXML
    private TextField nom_t;
    @FXML
    private TextField prix_t;
    @FXML
    private TableView<Ticket> tab;
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
        
        
        int pri=Integer.parseInt(prix_t.getText());
        
        
       
        Ticket e=new Ticket();
      e.setNom(nom_ev);
     
     e.setPrix(pri);
        ServiceTicket ev=new ServiceTicket();
       
        
        
        
        
        
        
        
        
        ev.Ajouter(e);
        show();
        
    }
    
     public void show(){
           ServiceTicket ev = new ServiceTicket();
            ObservableList<Ticket> list = ev.affichertick();
            
         
                nom.setCellValueFactory(new PropertyValueFactory<Ticket,String>("nom")); 
             
                  prix.setCellValueFactory(new PropertyValueFactory<Ticket,Integer>("prix"));
              
             
                 tab.setItems(list);
            
             
                
    }
    
       @FXML
      void getSelected(MouseEvent event){
     index=tab.getSelectionModel().getSelectedIndex();
     if(index<=-1){
         return ;
     }
     nom_t.setText(nom.getCellData(index).toString());
     
     
     
     
     
prix_t.setText(prix.getCellData(index).toString());
      

     }

    @FXML
    private void modif(ActionEvent event) {
        
         String nom_ev=nom_t.getText();
       
        
       int pri=Integer.parseInt(prix_t.getText());
        
       
      
        Ticket t=new Ticket();
      t.setNom(nom_ev);
      
     
      
      
      t.setPrix(pri);
       
        ServiceTicket ev=new ServiceTicket();
        t=tab.getSelectionModel().getSelectedItem();
             System.out.println("id evenements courant= "+t.getId());
        ev.updateTicket(t,nom_ev,pri);
       

   show();
        
        
        
    }

    @FXML
    private void dell(ActionEvent event) {
         ServiceTicket eve = new ServiceTicket();
              Ticket e= new Ticket();   
              e= tab.getSelectionModel().getSelectedItem();
              eve.delete(e);
          
             show();
    }

    @FXML
   private void pdf(ActionEvent event) throws SQLException {
        ServiceTicket as = new ServiceTicket();
        ObservableList<Ticket> list = as.affichertick();
        
        try{
            OutputStream file = new FileOutputStream(new File("C:\\Users\\Dell\\Desktop\\ticketpdf\\ticket.pdf"));
            Document document = new Document();
            PdfWriter.getInstance(document, file);
            document.open();
            
            Font font = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
            Paragraph pdfTitle = new Paragraph("Liste des tickets", font);
            pdfTitle.setAlignment(Element.ALIGN_CENTER);
            
            document.add(pdfTitle);
            document.add(new Chunk("\n"));
            PdfPTable table = new PdfPTable(2);
            table.setHeaderRows(1);
            
            table.addCell("nom");
            table.addCell("prix");
          System.out.println("ticket téléchargé en PDF avec succès");
            
            list.forEach((_item) -> {
              
                table.addCell(String.valueOf(_item.getPrix()));
             
                table.addCell(_item.getNom());
                
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
    private void tostat(ActionEvent event) {
            try{
            Parent root = FXMLLoader.load(getClass().getResource("/gui/stat.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    private void retour(ActionEvent event) {
            try{
            Parent root = FXMLLoader.load(getClass().getResource("/gui/FXML.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        
        
    }

   
    
}
