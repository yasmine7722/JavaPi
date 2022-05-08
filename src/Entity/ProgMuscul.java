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
public class ProgMuscul {
    
     private int id;
     private String nom;
     private Date date ;

    public ProgMuscul() {
    }

     
     
     
     
    @Override
    public String toString() {
        return "ProgMuscul{" + "id=" + id + ", nom=" + nom + ", date=" + date + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ProgMuscul(int id, String nom, Date date) {
        this.id = id;
        this.nom = nom;
        this.date = date;
    }

    public ProgMuscul(String nom, Date date) {
        this.nom = nom;
        this.date = date;
    }
     
    

   

    
    
    
    
    
}
