/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entity.Event;
import Entity.Ticket;
import Service.Mailling;
import Service.ServiceEvent;
import Service.ServiceTicket;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import static java.util.Collections.list;
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

    /**
     * Initializes the controller class.
     */
    public class FXMLController   implements Initializable {
    private Label label;
    @FXML
    private TextField tfnom_e;
   
    @FXML
    private DatePicker tfdate_fin;
    @FXML
    private Button Btn_modifier_e;
    @FXML
    private Button Btn_ajouter_e;
    @FXML
    private Button Btn_supprimer_e;
    @FXML
    private TableView<Event> table_e;
    @FXML
    private TableColumn<Event, String> nom_e;
    int index=-1;
    @FXML
    private TableColumn<Event, Date> date_fin;
    public ObservableList<Event> data=FXCollections.observableArrayList();
    @FXML
    private Button Btn_vider_e;
    @FXML
   
   
    private TextField desc;
    @FXML
    private TableColumn<Event, String> des_e;
    @FXML
    private TextField tsrearch;
    @FXML
    private Label errnom;
    @FXML
    private ComboBox<Ticket> comboticket;
    @FXML
    private TableColumn<Event,String> ticket_e;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        show();
         ServiceTicket cs = new ServiceTicket();
         List<Ticket> listcat = cs.affichertick()   ;
          
        ObservableList<Ticket> List = FXCollections.observableArrayList(listcat);
            comboticket.setItems(List);
       
        // TODO
    }    
     private boolean nom_evalide(){
        Pattern p = Pattern.compile("[a-zA-Z]+");
        Matcher m = p.matcher(tfnom_e.getText());
        if(m.find() && m.group().equals(tfnom_e.getText())){
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
     index=table_e.getSelectionModel().getSelectedIndex();
     if(index<=-1){
         return ;
     }
     
     
     tfnom_e.setText(nom_e.getCellData(index).toString());
     tfdate_fin.setValue(date_fin.getCellData(index).toLocalDate());
     desc.setText(des_e.getCellData(index).toString());
  
      

     }

      
     
     
    @FXML
    private void modifier_e(ActionEvent event) {
         
        String nom_ev=tfnom_e.getText();
       
        
        String des_ev=desc.getText();
         int tick_ev=comboticket.getValue().getId();
        
       
        Date date_fin_ev =  Date.valueOf(tfdate_fin.getValue());
        Event e=new Event();
      e.setNom(nom_ev);
      
     
      
      
      e.setDate(date_fin_ev);
       e.setDescription(des_ev);
        ServiceEvent ev=new ServiceEvent();
        e=table_e.getSelectionModel().getSelectedItem();
             System.out.println("id evenements courant= "+e.getId());
        ev.updateev(e,nom_ev,date_fin_ev,des_ev,tick_ev);
       

   show();

          }

    

    
    @FXML
    private void ajouter_e(ActionEvent event) {
         
        
     if (tfnom_e.getText().isEmpty())
         {
                        errnom.setText("nom Invalide");
                        errnom.setVisible(true);
                  
                        return;
                    }
      
        String nom_ev=tfnom_e.getText();
        String des_ev=desc.getText();
        Date date_fin_ev =  Date.valueOf(tfdate_fin.getValue());
        int idN = comboticket.getValue().getId();
       
        
        Event e=new Event();
      e.setNom(nom_ev);
      e.setDescription(des_ev);
      e.setDate(date_fin_ev);
      e.setTicket_id(idN);
    
      
      Mailling M = new Mailling() ; 
        M.sendEmail("youssef.sidhom@esprit.tn",e.getNom(),"Event ajouté avec succes");
      
        ServiceEvent ev=new ServiceEvent();
     
        ev.Ajouter(e);
       
           show();
         }

    @FXML
    private void supprimer_e(ActionEvent event) {
         ServiceEvent eve = new ServiceEvent();
              Event e= new Event();   
              e= table_e.getSelectionModel().getSelectedItem();
              eve.delete(e);
          
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
           ServiceEvent ev = new ServiceEvent();
            ObservableList<Event> list = ev.afficherEvent();
            
         
                nom_e.setCellValueFactory(new PropertyValueFactory<Event,String>("nom")); 
             
                  des_e.setCellValueFactory(new PropertyValueFactory<Event,String>("description"));
              
               date_fin.setCellValueFactory(new PropertyValueFactory<Event,Date>("date"));
               ticket_e.setCellValueFactory(new PropertyValueFactory<Event,String>("ticket_id"));
                 table_e.setItems(list);
            
              searchEven(); 
                
    }
 
         
     

    @FXML
    private void vider_e(ActionEvent event) {
          tfnom_e.clear();
        
        desc.clear();
        
        tfdate_fin.setValue(null); 
        comboticket.setValue(null); 
    }
    
        public void searchEven(){
       
ServiceEvent eve = new ServiceEvent();
         ObservableList <Event> l = eve.afficherEvent();        
         try{
        
          table_e.setItems(l);
          FilteredList<Event> f = new FilteredList<>(l, b -> true);
          tsrearch.textProperty().addListener((ObservableValue<? extends String> observable, String olValue, String newValue)->{
             f.setPredicate(new Predicate<Event>() {
                 public boolean test(Event person) {
                     if(newValue == null|| newValue.isEmpty()){
                         return true;
                     }
                     String lowerCaseFilter= newValue.toLowerCase();
                     
                     if(person.getNom().toLowerCase().contains(lowerCaseFilter)){
                         return true;
                     }
                     else if(String.valueOf(person.getDescription()).indexOf(lowerCaseFilter)!=-1)
                         return true;
                     else
                         return false;
                 }

             
             });
             });
         SortedList<Event> sortedData = new SortedList<>(f);
         sortedData.comparatorProperty().bind(table_e.comparatorProperty());
         table_e.setItems(sortedData);

         }catch(Exception e){
             System.out.println(e.getMessage());
                 }  
       
    
   
     }
        
      @FXML
   private void pdf(ActionEvent event) throws SQLException {
        ServiceEvent as = new ServiceEvent();
        ObservableList<Event> list = as.afficherEvent();
        
        try{
            OutputStream file = new FileOutputStream(new File("C:\\Users\\Dell\\Desktop\\evnetpdf\\evenement.pdf"));
            Document document = new Document();
            PdfWriter.getInstance(document, file);
            document.open();
            
            Font font = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
            Paragraph pdfTitle = new Paragraph("Liste des Evenement", font);
            pdfTitle.setAlignment(Element.ALIGN_CENTER);
            
            document.add(pdfTitle);
            document.add(new Chunk("\n"));
            PdfPTable table = new PdfPTable(4);
            table.setHeaderRows(1);
            
            table.addCell("nom");
            table.addCell("descrip");
            table.addCell("date");
            table.addCell("ticket_id");
          System.out.println("Event téléchargé en PDF avec succès");
            
            list.forEach((_item) -> {
               table.addCell(_item.getNom());
                table.addCell(_item.getDescription());
                table.addCell(String.valueOf(_item.getDate()));
                table.addCell(String.valueOf(_item.getTicket_id()));
             
               
                
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
    private void toticket(ActionEvent event) {
            try{
            Parent root = FXMLLoader.load(getClass().getResource("/gui/Ticket.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

   
}
    
    
    
    

    

