/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author toshiba
 */
public class Event {

   
    
    
    private int id;
    private String nom;

    @Override
    public String toString() {
        return "Event{" + "id=" + id + ", nom=" + nom + '}';
    }
    
    
    
     public Event() {
    }
    

    public Event(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Event(String nom) {
        this.nom = nom;
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
    
    
    
    
    
    
    
    
}
