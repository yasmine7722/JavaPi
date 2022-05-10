/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entity.Article;
import Entity.Categorie;
import Service.Mailling;
import Service.ServiceBlog;
import Service.ServiceCategorie;
import com.itextpdf.text.Chunk;
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
import java.io.OutputStream;
import java.sql.SQLException;


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
    private TableView<Article> table_e;
    @FXML
    private TableColumn<Article, String> nom_e;
    int index=-1;
    @FXML
    private TableColumn<Article, Date> date_fin;
    public ObservableList<Article> data=FXCollections.observableArrayList();
    @FXML
    private Button Btn_vider_e;
    @FXML
   
   
    private TextField desc;
    @FXML
    private TableColumn<Article, String> des_e;
    @FXML
    private TextField tsrearch;
    @FXML
    private Label errnom;
    @FXML
    private ComboBox<Categorie> comboticket;
    @FXML
    private TableColumn<Article,String> ticket_e;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        show();
         ServiceCategorie cs = new ServiceCategorie();
         List<Categorie> listcat = cs.affichercategorie()   ;
          
        ObservableList<Categorie> List = FXCollections.observableArrayList(listcat);
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
                alert.setContentText("Veuillez entrer un nom valide !");
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
        Article e=new Article();
      e.setTheme(nom_ev);
   
      e.setDate(date_fin_ev);
       e.setDescription(des_ev);
        ServiceBlog ev=new ServiceBlog();
        e=table_e.getSelectionModel().getSelectedItem();
             System.out.println("id Article courant= "+e.getId());
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
       
        
        Article e=new Article();
      e.setTheme(nom_ev);
      e.setDescription(des_ev);
      e.setDate(date_fin_ev);
      e.setCategorie_id(idN);
      Mailling M = new Mailling() ; 
      M.sendEmail("mahdi.baccouche@esprit.tn",e.getTheme(),"Article ajouté avec succes");
      
        
        
        
        ServiceBlog ev=new ServiceBlog();
     
        ev.Ajouter(e);
       
           show();
           
           
         }

    @FXML
    private void supprimer_e(ActionEvent event) {
         ServiceBlog eve = new ServiceBlog();
              Article e= new Article();   
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
           ServiceBlog ev = new ServiceBlog();
            ObservableList<Article> list = ev.afficherArticle();
            
         
                nom_e.setCellValueFactory(new PropertyValueFactory<Article,String>("theme")); 
             
                  des_e.setCellValueFactory(new PropertyValueFactory<Article,String>("description"));
              
               date_fin.setCellValueFactory(new PropertyValueFactory<Article,Date>("date"));
               ticket_e.setCellValueFactory(new PropertyValueFactory<Article,String>("categorie_id"));
                 table_e.setItems(list);
            
              searchEven(); 
                
    }
 
         
     

    @FXML
    private void vider_e(ActionEvent event) {
          tfnom_e.clear();
        
        desc.clear();
        
        tfdate_fin.setValue(null);  
    }
    
        public void searchEven(){
       
ServiceBlog eve = new ServiceBlog();
         ObservableList <Article> l = eve.afficherArticle();        
         try{
        
          table_e.setItems(l);
          FilteredList<Article> f = new FilteredList<>(l, b -> true);
          tsrearch.textProperty().addListener((ObservableValue<? extends String> observable, String olValue, String newValue)->{
             f.setPredicate(new Predicate<Article>() {
                 public boolean test(Article person) {
                     if(newValue == null|| newValue.isEmpty()){
                         return true;
                     }
                     String lowerCaseFilter= newValue.toLowerCase();
                     
                     if(person.getTheme().toLowerCase().contains(lowerCaseFilter)){
                         return true;
                     }
                     else if(String.valueOf(person.getDescription()).indexOf(lowerCaseFilter)!=-1)
                         return true;
                     else
                         return false;
                 }

             
             });
             });
         SortedList<Article> sortedData = new SortedList<>(f);
         sortedData.comparatorProperty().bind(table_e.comparatorProperty());
         table_e.setItems(sortedData);

         }catch(Exception e){
             System.out.println(e.getMessage());
                 }  
       
    
   
     }

    @FXML
    private void pdf(ActionEvent event) throws SQLException {
        ServiceBlog as = new ServiceBlog();
        ObservableList<Article> list = as.afficherArticle();
        
        try{
            OutputStream file = new FileOutputStream(new File("C:\\Users\\mahdy\\Desktop\\PDF\\article.pdf"));
            Document document = new Document();
            PdfWriter.getInstance(document, file);
            document.open();
            
            Font font = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
            Paragraph pdfTitle = new Paragraph("Liste ARTICLES", font);
            pdfTitle.setAlignment(Element.ALIGN_CENTER);
            
            document.add(pdfTitle);
            document.add(new Chunk("\n"));
            PdfPTable table = new PdfPTable(4);
            table.setHeaderRows(1);
            
            table.addCell("theme");
            table.addCell("description");
            table.addCell("date");
            table.addCell("categorie_id");
            
            
            list.forEach((_item) -> {
                table.addCell(_item.getTheme());
                table.addCell(String.valueOf(_item.getDescription()));
                table.addCell(String.valueOf(_item.getDate()));
                table.addCell(String.valueOf(_item.getCategorie_id()));
               
                
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
    
    
    

}
    
    
    
    

    

