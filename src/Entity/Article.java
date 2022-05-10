/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;


import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 *
 * @author toshiba
 */
public class Article {

   
   
    
    
    private int id;
    private String theme , description;
    private Date date;
    private int categorie_id ;
    
    
    private Categorie categorie ;

    public Article(String theme, String description, Date date, int categorie_id) {
        this.theme = theme;
        this.description = description;
        this.date = date;
        this.categorie_id = categorie_id;
    }
 public Article(String theme, String description) {
        this.theme = theme;
        this.description = description;
      
    }
    public int getCategorie_id() {
        return categorie_id;
    }

    public void setCategorie_id(int categorie_id) {
        this.categorie_id = categorie_id;
    }



    
    
    
    
    public Article() {
    }

    public Article(int id, String theme, String description, Date date) {
        this.id = id;
        this.theme = theme;
        this.description = description;
        this.date = date;
    }

    public Article(String theme, String description, Date date) {
        this.theme = theme;
        this.description = description;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Article{" + "id=" + id + ", theme=" + theme + ", description=" + description + ", date=" + date + '}';
    }

   

   
    
    
    
    
    
    
}
