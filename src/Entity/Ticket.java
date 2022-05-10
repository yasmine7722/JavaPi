/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.time.LocalDateTime;

/**
 *
 * @author Dell
 */
public class Ticket {

    public Ticket() {
    }
    
        private int id,prix;
    private String nom ;
    

   

    @Override
    public String toString() {
        return "Event{" + "id=" + id + ", nom=" + nom + ", prix=" + prix +  '}';
    }

    public Ticket(String nom, int prix) {
        this.nom = nom;
        this.prix = prix;
       
    }

    public Ticket(int id, String nom, int prix) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
     
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Ticket(int id, int prix, String nom) {
        this.id = id;
        this.prix = prix;
        this.nom = nom;
    }

    public Ticket(int prix, String nom) {
        this.prix = prix;
        this.nom = nom;
    }
    
    
    
    
    
}
