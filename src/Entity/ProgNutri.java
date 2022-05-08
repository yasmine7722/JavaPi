/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author toshiba
 */
public class ProgNutri {
    
      private int id;
    private String nom;
  

    @Override
    public String toString() {
        return "ProgNutri{" + "id=" + id + ", nom=" + nom + '}';
    }

    
    
    
    
    public ProgNutri(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public ProgNutri() {
    }

    public ProgNutri(String nom) {
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
