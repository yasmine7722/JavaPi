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
public class Event {

   
   
    
    
    private int id;
    private String nom , description;
    private Date date;
    private int ticket_id ;
    
    
    private Ticket ticket ;

    public Event(String nom, String description, Date date, int ticket_id) {
        this.nom = nom;
        this.description = description;
        this.date = date;
        this.ticket_id = ticket_id;
    }
 public Event(String nom, String description) {
        this.nom = nom;
        this.description = description;
      
    }
    public int getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(int ticket_id) {
        this.ticket_id = ticket_id;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    
    
    
    
    public Event() {
    }

    public Event(int id, String nom, String description, Date date) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.date = date;
    }

    public Event(String nom, String description, Date date) {
        this.nom = nom;
        this.description = description;
        this.date = date;
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
        return "Event{" + "id=" + id + ", nom=" + nom + ", description=" + description + ", date=" + date + '}';
    }

   

   
    
    
    
    
    
    
}
